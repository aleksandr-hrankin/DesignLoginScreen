package ua.antibyte.designloginscreen.presentation.fragment.welcome

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_welcome.*
import ua.antibyte.designloginscreen.R
import ua.antibyte.designloginscreen.presentation.fragment.auth.AuthFragment
import ua.antibyte.designloginscreen.presentation.fragment.auth.AuthTabModel

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        btn_welcome_sign_in.setOnClickListener { onSignInButtonClick() }
        btn_welcome_create_account.setOnClickListener { onCreateAccountButtonClick() }
    }

    private fun onSignInButtonClick() {
        showAuthFragment(AuthTabModel.AuthType.SIGN_IN)
    }

    private fun onCreateAccountButtonClick() {
        showAuthFragment(AuthTabModel.AuthType.CREATE_ACCOUNT)
    }

    private fun showAuthFragment(authType: AuthTabModel.AuthType) {
        val fragment = AuthFragment()
        val bundle = Bundle()
        bundle.putSerializable(AuthFragment.AUTH_TYPE_KEY, authType)
        fragment.arguments = bundle
        fragment.show(parentFragmentManager, AuthFragment.TAG)
    }
}