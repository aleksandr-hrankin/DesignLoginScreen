package ua.antibyte.designloginscreen.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ua.antibyte.designloginscreen.R
import ua.antibyte.designloginscreen.presentation.fragment.welcome.WelcomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, WelcomeFragment())
            .commit()
    }
}