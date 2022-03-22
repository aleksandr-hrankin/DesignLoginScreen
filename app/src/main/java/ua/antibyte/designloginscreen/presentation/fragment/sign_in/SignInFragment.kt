package ua.antibyte.designloginscreen.presentation.fragment.sign_in

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sign_in.*
import ua.antibyte.designloginscreen.R

class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
    }

    override fun onPause() {
        super.onPause()
        hideErrorText()
    }

    private fun setOnClickListeners() {
        btn_sign_in_facebook.setOnClickListener { onMockClick() }
        btn_sign_in_twitter.setOnClickListener { onMockClick() }
        btn_sign_in_whatsapp.setOnClickListener { onMockClick() }
        btn_sign_in_forgot_password.setOnClickListener { onMockClick() }
        btn_sign_in_done.setOnClickListener { onOkButtonClick() }
    }

    private fun onMockClick() {
        Toast.makeText(context, "Mock", Toast.LENGTH_SHORT).show()
    }

    private fun onOkButtonClick() {
        val email = et_sign_in_email.text.toString()
        val password = et_sign_in_password.text.toString()

        if (email.isEmpty() or password.isEmpty()) {
            showErrorText()
        }
    }

    private fun showErrorText() {
        tv_sign_in_error_text.visibility = View.VISIBLE
    }

    private fun hideErrorText() {
        tv_sign_in_error_text.visibility = View.GONE
    }
}