package com.example.brick_bracker
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var brickContainer: BrickContainer
    private lateinit var paddle: Paddle
    private lateinit var ball: Ball
    private lateinit var scoreText: TextView
    private lateinit var sharedPreferences: SharedPreferences
    private var highScore = 0
    private val sharedPreferencesKey = "BrickBreakerHighScore"

    private var score = 0
    private var lives = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        brickContainer = findViewById(R.id.brickContainer)
        paddle = findViewById(R.id.paddle)
        ball = findViewById(R.id.ball)
        scoreText = findViewById(R.id.scoreText)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        highScore = sharedPreferences.getInt(sharedPreferencesKey, 0)

        startGame()
    }

    private fun startGame() {
        score = 0
        lives = 3
        scoreText.text = "Score: $score"

        // Initialize bricks
        brickContainer.initializeBricks()

        // Set ball and paddle positions
        ball.x = paddle.x + paddle.width / 2
        ball.y = paddle.y - ball.radius * 2

        // Set ball speed
        ball.speedX = 3f
        ball.speedY = -3f

        // Start the game loop
        ball.start()
    }

    private fun gameOver() {
        // Display a game over message or perform other actions
        scoreText.text = "Game Over"

        // Update the high score if necessary
        updateHighScore()

        // Show the high score activity
        val intent = Intent(this, HighScoreActivity::class.java)
        startActivity(intent)
    }

    private fun updateHighScore() {
        if (score > highScore) {
            highScore = score
            val editor = sharedPreferences.edit()
            editor.putInt(sharedPreferencesKey, highScore)
            editor.apply()
        }
    }
}