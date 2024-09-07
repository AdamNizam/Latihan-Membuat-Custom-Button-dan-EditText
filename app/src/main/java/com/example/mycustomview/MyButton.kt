package com.example.mycustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class MyButton : AppCompatButton {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet): super(context, attr)

    private var txtColor: Int = 0
    private var enabledBackground: Drawable
    private var disabledBackground: Drawable

    init {
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
        enabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button) as Drawable
        disabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button_disable) as Drawable
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        background =  if(isEnabled) enabledBackground else disabledBackground
        setTextColor(txtColor)
        textSize = 12f
        gravity = Gravity.CENTER
        text = if (isEnabled) "submit" else "Isi Dulu"
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val params = layoutParams as ViewGroup.MarginLayoutParams
        params.topMargin = 50 // Contoh margin dalam pixel
        layoutParams = params
    }

}