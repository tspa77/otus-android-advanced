package com.example.viewsandcanvas.customui

import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.a03kotlincoroutines.R

class Vote(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var vote: Float = 0f
    private val circle = RectF()
    private var sweepAngle = 0f

    private val paintCircle: Paint = Paint().apply {
        color = context.getColor(R.color.colorPrimary)
        strokeWidth = 3f
    }

    private val fillSector = Paint().apply {
        color = context.getColor(R.color.colorPrimaryDark)
        strokeWidth = 1f
        style = Paint.Style.FILL
    }

    private val paintText: Paint = Paint().apply {
        color = context.getColor(R.color.cardview_light_background)
        textAlign = Paint.Align.CENTER
        textSize = 60f
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        circle.bottom = height.toFloat()
        circle.right = width.toFloat()
    }


    fun startAnimation() {
        val sweepAngleBoundary = 360 / 10 * vote
        val propertySweepAngle = "sweepAngle"
        val propertyValuesHolder = PropertyValuesHolder.ofFloat(
            propertySweepAngle, 0f, sweepAngleBoundary
        )
        val valueAnimator = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolder)
            .apply {
                duration = 750
                addUpdateListener {
                    sweepAngle = it.getAnimatedValue(propertySweepAngle) as Float
                    invalidate()
                }
            }
        valueAnimator.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)

        if (canvas == null) return

        val midHeight = height / 2f
        val midWidth = width / 2f

        canvas.run {
            drawCircle(midWidth, midHeight, midHeight, paintCircle)
            drawArc(circle, -90f, sweepAngle, true, fillSector)
            drawText(vote.toString(), midWidth, midHeight + paintText.textSize / 3, paintText)
        }
        // Магическая тройка ¯\_(ツ)_/¯ - думал для того, чтобы отцентровать текст по вертикали
        // нужно пополам высоту его разделить, но не вышло. Путём подбора пришёл к тройке :(
    }


    fun setVote(vote: Float) {
        this.vote = vote

        startAnimation()
    }
}
