package com.example.brick_bracker

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BrickContainer(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val bricks = mutableListOf<Brick>()
    private val brickWidth = 100
    private val brickHeight = 40
    private val brickMargin = 4

    init {
        for (i in 0 until 9) {
            for (j in 0 until 10) {
                val brick = Brick(context)
                brick.x = (j * (brickWidth + brickMargin)).toFloat()
                brick.y = (i * (brickHeight + brickMargin)).toFloat()
                bricks.add(brick)
            }
        }
    }

    fun initializeBricks() {
        for (brick in bricks) {
            brick.visibility = View.VISIBLE
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = 0xFFFF0000.toInt()

        for (brick in bricks) {
            if (brick.visibility == View.VISIBLE) {
                canvas.drawRect(brick.x, brick.y, brick.x + brickWidth, brick.y + brickHeight, paint)
            }
        }
    }
}