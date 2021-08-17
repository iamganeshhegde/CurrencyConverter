package com.example.currencyconverter.miscellaneous

import android.R
import android.content.Context
import android.graphics.*
import androidx.appcompat.widget.AppCompatImageView


class BorderImageView(context:Context) : AppCompatImageView(context) {
    init {

        init()
    }

    private val STROKE_WIDTH_DP = 6
    private var paintBorder: Paint? = null
    lateinit var bitmap: Bitmap
    private var strokeWidthPx = 0
    private var rectF: RectF? = null


    private fun init() {
        // The resource is embedded, but it can be easily moved in the constructor.
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_dialog_map)

        // The same goes for the stroke width in dp.
        strokeWidthPx = (STROKE_WIDTH_DP * resources.displayMetrics.density).toInt()
        val halfStrokeWidthPx = strokeWidthPx / 2
        paintBorder = Paint()
        paintBorder!!.style = Paint.Style.STROKE
        // Stroke width is in pixels.
        paintBorder!!.strokeWidth = strokeWidthPx.toFloat()
        // Our color for the border.
        paintBorder!!.color = Color.BLUE
        val totalWidth = bitmap.getWidth() + strokeWidthPx * 2
        val totalHeight = bitmap.getHeight() + strokeWidthPx * 2

        // An empty bitmap with the same size of our resource to display, increased of the desired border width.
        setImageBitmap(Bitmap.createBitmap(totalWidth, totalHeight, Bitmap.Config.ARGB_8888))

        // The rectangle that will be used for drawing the colored border.
        rectF = RectF(
            halfStrokeWidthPx.toFloat(),
            halfStrokeWidthPx.toFloat(),
            (totalWidth - halfStrokeWidthPx).toFloat(),
            (totalHeight - halfStrokeWidthPx).toFloat()
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // A rounded rect will be printed.
        canvas.drawRoundRect(rectF!!, 40f, 40f, paintBorder!!)

        val paint = Paint()
        paint.setShadowLayer(30f, 30f, 30f, -0xaaaaab)
        // The bitmap for the resource R.drawable.pspdfkit_icon.
        // Note the Paint for the bitmap is null, we'll talk about this in a moment...
        canvas.drawBitmap(bitmap!!, strokeWidthPx.toFloat(), strokeWidthPx.toFloat(), paint )
    }
}