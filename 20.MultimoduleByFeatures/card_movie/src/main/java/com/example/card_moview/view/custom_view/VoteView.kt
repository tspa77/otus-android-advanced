package com.example.card_moview.view.custom_view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.card_moview.R


class VoteView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    companion object {
        const val CIRCLE_VOTE_TEXT_RATIO = 2.25F
        const val CIRCLE_VOTE_ANIMATION_DURATION = 750L
    }

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
        color = context.getColor(R.color.colorVoteNumber)
        textAlign = Paint.Align.CENTER
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        circle.bottom = h.toFloat()
        circle.right = w.toFloat()
        midHeight = h / 2f
        midWidth = w / 2f

        // set text parameters
        paintText.textSize = circle.bottom / CIRCLE_VOTE_TEXT_RATIO
        val offsetY = (paintText.descent() + paintText.ascent()) / 2
        textWidthGuideline = midWidth - offsetY
    }

    fun startAnimation() {
        val sweepAngleBoundary = 360 / 10 * vote
        val valueAnimator = ValueAnimator.ofFloat(0f, sweepAngleBoundary)
        valueAnimator.apply {
            duration =
                CIRCLE_VOTE_ANIMATION_DURATION
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
