package com.example.viewsandcanvas.customui

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View

class Vote(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val tag = "CustomView"

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        Log.d(tag, "onMeasure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        Log.d(tag, "onLayout")
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)

        Log.d(tag, "dispatchDraw")
    }

    fun setValues(values: Float){
        Log.d(tag, "setValues")
    }
}