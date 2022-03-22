package ua.antibyte.designloginscreen.common.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import ua.antibyte.designloginscreen.R

class PasswordEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {
    private var isShowPassword = false

    init {
        val listener = createTouchListener()
        setOnTouchListener(listener)
        setEndDrawable(R.drawable.ic_password_hide)
    }

    private fun togglePasswordVisibility() {
        if (isShowPassword) {
            isShowPassword = false
            hidePassword()
        } else {
            isShowPassword = true
            showPassword()
        }
    }

    private fun showPassword() {
        setEndDrawable(R.drawable.ic_password_show)
        transformationMethod = HideReturnsTransformationMethod.getInstance()
    }

    private fun hidePassword() {
        setEndDrawable(R.drawable.ic_password_hide)
        transformationMethod = PasswordTransformationMethod.getInstance()
    }

    private fun setEndDrawable(resId: Int) {
        val drawable = ResourcesCompat.getDrawable(resources, resId, null)
        val wrappedDrawable = DrawableCompat.wrap(drawable!!)
        DrawableCompat.setTint(wrappedDrawable, Color.BLACK)

        drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        if (isRtl()) {
            setCompoundDrawables(drawable, null, null, null)
        } else {
            setCompoundDrawables(null, null, drawable, null)
        }
    }

    private fun isRtl() = resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL

    @SuppressLint("ClickableViewAccessibility")
    private fun createTouchListener() = object : OnTouchListener {
        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            val drawableStart = 0
            val drawableEnd = 2

            if (event?.action == MotionEvent.ACTION_UP) {
                if (isRtl()) {
                    if (event.rawX <= (left + compoundDrawables[drawableStart].bounds.width())) {
                        togglePasswordVisibility()
                        return true
                    }
                } else {
                    if (event.rawX >= (right - compoundDrawables[drawableEnd].bounds.width())) {
                        togglePasswordVisibility()
                        return true
                    }
                }
            }
            return false
        }
    }
}