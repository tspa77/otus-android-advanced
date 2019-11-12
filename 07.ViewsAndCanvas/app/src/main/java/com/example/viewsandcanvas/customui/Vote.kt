package com.example.viewsandcanvas.customui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.a03kotlincoroutines.R

class Vote(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val tag = "CustomView"
    private var vote: Float = 0f

    private val paintCircle: Paint = Paint().apply {
        color = context.getColor(R.color.colorPrimary)
        strokeWidth = 3f
    }

    private val paintText: Paint = Paint().apply {
        color = context.getColor(R.color.cardview_light_background)
        textAlign = Paint.Align.CENTER
        textSize = 60f
    }

//    fun startAnimation() {
//        val valueAnimator = ValueAnimator.of
//    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)

        if (canvas == null) return

        val midHeight = height / 2f
        val midWidth = width / 2f

        canvas.drawCircle(midWidth, midHeight, 75f, paintCircle)
        canvas.drawText(vote.toString(), midWidth, midHeight + paintText.textSize / 3, paintText)
        // Магическая тройка ¯\_(ツ)_/¯ - думал для того чтобы отцентровать текст по вертикали нужно
        // пополам высоту его разделить, но не вышло. Путём подбора пришёл к тройке :(

        Log.d(tag, "dispatchDraw ")
    }


    fun setVote(vote: Float) {
        this.vote = vote

        invalidate()

        Log.d(tag, "setVote")
    }
}
