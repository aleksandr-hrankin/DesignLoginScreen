package ua.antibyte.designloginscreen.presentation.fragment.create_account

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_create_account.*
import ua.antibyte.designloginscreen.R

class CreateAccountFragment : Fragment(R.layout.fragment_create_account) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
    }

    override fun onPause() {
        super.onPause()
        hideErrorText()
    }

    private fun setOnClickListeners() {
        btn_create_account_facebook.setOnClickListener { onMockClick() }
        btn_create_account_twitter.setOnClickListener { onMockClick() }
        btn_create_account_whatsapp.setOnClickListener { onMockClick() }
        btn_create_account_registration.setOnClickListener { onRegistrationButtonClick() }
    }

    private fun onMockClick() {
        Toast.makeText(context, "Mock", Toast.LENGTH_SHORT).show()
    }

    private fun onRegistrationButtonClick() {
        val fullName = et_create_account_full_name.text.toString()
        val email = et_create_account_email.text.toString()
        val password = et_create_account_password.text.toString()

        if (fullName.isEmpty() or email.isEmpty() or password.isEmpty()) {
            showErrorText()
        }
    }

    private fun showErrorText() {
        tv_create_account_error_text.visibility = View.VISIBLE
    }

    private fun hideErrorText() {
        tv_create_account_error_text.visibility = View.GONE
    }
}