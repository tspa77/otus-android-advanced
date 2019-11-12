package com.example.viewsandcanvas.customui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView

class ImageViewTornEdges(context: Context, attributeSet: AttributeSet) :
    ImageView(context, attributeSet) {

    private val rect = RectF()

    private val strokePaint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 2f
        style = Paint.Style.FILL
        pathEffect = DiscretePathEffect(5f, 20f)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        rect.bottom = height.toFloat()
        rect.right = width.toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas == null) return

        canvas.drawRect(rect, strokePaint)
    }

}