package ua.antibyte.designloginscreen.presentation.fragment.auth

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_auth.*
import ua.antibyte.designloginscreen.R
import ua.antibyte.designloginscreen.presentation.fragment.create_account.CreateAccountFragment
import ua.antibyte.designloginscreen.presentation.fragment.sign_in.SignInFragment

class AuthFragment : BottomSheetDialogFragment() {
    companion object {
        @JvmField
        val TAG: String = AuthFragment::class.java.simpleName
        const val AUTH_TYPE_KEY: String = "AUTH_TYPE_KEY"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auth, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabList = createTabList()
        val adapter = AuthAdapter(this, tabList)

        initViewPager(adapter)
        initTabLayout(tabList)
        setSelectedTab(tabList)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val listener = createOnShowListener()
        dialog.setOnShowListener(listener)
        return dialog
    }

    private fun createOnShowListener() = DialogInterface.OnShowListener {
        val bottomSheetDialog = it as BottomSheetDialog
        val bottomSheetLayout = bottomSheetDialog.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
        BottomSheetBehavior.from(bottomSheetLayout).state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }

    private fun setSelectedTab(tabList: List<AuthTabModel>) {
        val tabType = arguments?.getSerializable(AUTH_TYPE_KEY)

        for (i in tabList.indices) {
            if (tabList[i].tabType == tabType) {
                vp_authentication.currentItem = i
            }
        }
    }

    private fun initViewPager(adapter: AuthAdapter) {
        vp_authentication.offscreenPageLimit = adapter.itemCount
        vp_authentication.adapter = adapter
    }

    private fun initTabLayout(tabList: List<AuthTabModel>) {
        TabLayoutMediator(tl_authentication, vp_authentication) { tab, position ->
            tab.text = tabList[position].tabName
        }.attach()
    }

    private fun createTabList() = arrayListOf(
        AuthTabModel("Create Account", AuthTabModel.AuthType.CREATE_ACCOUNT, CreateAccountFragment()),
        AuthTabModel("Sign In", AuthTabModel.AuthType.SIGN_IN, SignInFragment())
    )
}