package ua.antibyte.designloginscreen.presentation.fragment.auth

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AuthAdapter(
    private val fragment: Fragment,
    private val tabList: List<AuthTabModel>
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return tabList.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabList[position].tabFragment
    }
}