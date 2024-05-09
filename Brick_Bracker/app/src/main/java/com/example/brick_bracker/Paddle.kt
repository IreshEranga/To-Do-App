package com.example.brick_bracker

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class Paddle(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val paint = Paint()

    init {
        paint.color = 0xFF0000FF.toInt()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                x = event.rawX - width / 2
            }
        }
        return true
    }
}