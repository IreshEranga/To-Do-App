package com.example.brick_bracker

import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.Style
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator

class Ball(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val paint = Paint()
    var speedX = 0f
    var speedY = 0f
    var radius = 20

    private val animator = ValueAnimator.ofFloat(0f, 1f)

    init {
        paint.color = 0xFFFFFF00.toInt()
        paint.style = Style.FILL

        animator.interpolator = LinearInterpolator()
        animator.duration = 10
        animator.addUpdateListener(object : AnimatorUpdateListener {
            override fun onAnimationUpdate(animation: ValueAnimator) {
                x += speedX
                y += speedY

                invalidate()
            }
        })
    }

    fun start() {
        animator.start()
    }

    fun stop() {
        animator.pause()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(x.toFloat(), y.toFloat(), radius.toFloat(), paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                speedX = 3f
                speedY = -3f
            }
        }
        return true
    }
}