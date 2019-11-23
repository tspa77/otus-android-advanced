package com.example.viewsandcanvas.customui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.viewsandcanvas.AppConstants.CIRCLE_VOTE_ANIMATION_DURATION
import com.example.viewsandcanvas.AppConstants.CIRCLE_VOTE_TEXT_RATIO
import com.example.viewsandcanvas.R


class Vote(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var vote: Float = 0f
    private val circle = RectF()
    private var sweepAngle = 0f
    private var midHeight = 0f
    private var midWidth = 0f
    private var textWidthGuideline = 0f


    private val paintCircle = Paint().apply {
        isAntiAlias = true
        color = context.getColor(R.color.colorPrimary)
    }

    private val fillSector = Paint().apply {
        isAntiAlias = true
        color = context.getColor(R.color.colorPrimaryDark)
        strokeWidth = 1f
        style = Paint.Style.FILL
    }

    private val paintText = Paint().apply {
        isAntiAlias = true
        color = context.getColor(R.color.cardview_light_background)
        textAlign = Paint.Align.CENTER
    }

    // Определяет центр текста. Там не всё так просто...
    // Оказывается, графически/визуально, середина текста это не половина его высоты  ¯\_(ツ)_/¯
    // https://proandroiddev.com/expounding-android-canvas-drawtext-bae3d4fabc5a
    // https://stackoverflow.com/questions/7549182/android-paint-measuretext-vs-gettextbounds/57288746#57288746
    // Но в моём случае, где текст это только цифры, вполне бы хватило моей магической тройки,
    // которую я получил эмпирически :) Но всё же вот метод
    private fun getTextHeight(paint: Paint): Int {
        val bounds = Rect()
        paint.getTextBounds(vote.toString(), 0, 1, bounds)
        return bounds.bottom + bounds.height()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        circle.bottom = height.toFloat()
        circle.right = width.toFloat()
        midHeight = height / 2f
        midWidth = width / 2f

        // set text parameters
        paintText.textSize = circle.bottom / CIRCLE_VOTE_TEXT_RATIO
        textWidthGuideline = midWidth + getTextHeight(paintText) / 2f
    }


    fun startAnimation() {
        val sweepAngleBoundary = 360 / 10 * vote
        val valueAnimator = ValueAnimator.ofFloat(0f, sweepAngleBoundary)
//        val propertySweepAngle = "sweepAngle"
//        val propertyValuesHolder = PropertyValuesHolder.ofFloat(
//            propertySweepAngle, 0f, sweepAngleBoundary
//        )
//        val valueAnimator = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolder)
//            .apply {
//                duration = CIRCLE_VOTE_ANIMATION_DURATION
//                addUpdateListener {
//                    sweepAngle = it.getAnimatedValue(propertySweepAngle) as Float
//                    invalidate()
//                }
//            }
        valueAnimator.apply {
            duration = CIRCLE_VOTE_ANIMATION_DURATION
            addUpdateListener {
                sweepAngle = it.animatedValue as Float
                invalidate()
            }
            start()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)

        if (canvas == null) return

        canvas.run {
            drawCircle(midWidth, midHeight, midHeight, paintCircle)
            drawArc(circle, -90f, sweepAngle, true, fillSector)
            drawText(vote.toString(), midWidth, textWidthGuideline, paintText)
        }
    }


    fun setVote(vote: Float) {
        this.vote = vote

        startAnimation()
    }
}
