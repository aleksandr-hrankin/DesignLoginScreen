package ua.antibyte.designloginscreen.presentation.fragment.auth

import androidx.fragment.app.Fragment

data class AuthTabModel(
    val tabName: String,
    val tabType: AuthType,
    val tabFragment: Fragment
) {
    enum class AuthType {
        SIGN_IN, CREATE_ACCOUNT
    }
}
