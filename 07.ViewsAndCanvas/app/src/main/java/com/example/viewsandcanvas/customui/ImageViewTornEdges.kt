package com.example.viewsandcanvas.customui

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.widget.ImageView
import com.example.viewsandcanvas.AppConstants.TORN_EDGES_DEVIATION
import com.example.viewsandcanvas.AppConstants.TORN_EDGES_SEGMENT_LENGTH
import kotlin.math.roundToInt


class ImageViewTornEdges(context: Context, attributeSet: AttributeSet) :
    ImageView(context, attributeSet) {

    override fun onDraw(canvas: Canvas?) {
        if (canvas == null || drawable == null) return
        drawRoundImage(canvas)
    }

    private fun drawRoundImage(canvas: Canvas) {
        val b = (drawable as BitmapDrawable).bitmap
        val bitmap = b.copy(Bitmap.Config.ARGB_8888, true)

        // Scale the bitmap
        val ratio = bitmap.width.toFloat() / bitmap.height.toFloat()
        val height = (width / ratio).roundToInt()
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false)

        // Cutting the outer
        val shader = BitmapShader(scaledBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        val rect = RectF()
        rect.set(0f, 0f, width.toFloat(), height.toFloat())

        val imagePaint = Paint().apply {
            isAntiAlias = true
            this.shader = shader
            pathEffect = DiscretePathEffect(TORN_EDGES_SEGMENT_LENGTH, TORN_EDGES_DEVIATION)
        }

        canvas.drawRect(rect, imagePaint)
    }
}
