package com.example.brick_bracker

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View
import android.view.View.VISIBLE

class Brick(context: Context) : View(context) {

    init {
        visibility = VISIBLE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = 0xFFFF0000.toInt()

        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}