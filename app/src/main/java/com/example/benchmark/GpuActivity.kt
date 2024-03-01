package com.example.benchmark

import androidx.appcompat.app.AppCompatActivity
import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class GpuActivity : AppCompatActivity() {
    private lateinit var result: TextView
    private lateinit var imageView: ImageView
    private var startTime: Long = 0
    private var frameCount: Int = 0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gpu)
        initData()
    }
    private fun initData() {
        result = findViewById(R.id.tvResult)
        imageView=findViewById(R.id.imageView)
        setupAnimation()
    }
    private fun setupAnimation() {
        // configurare animatie-set up
        val animator = ValueAnimator.ofFloat(0f, 500f)
        animator.duration = 1000 // Durata animatiei in milisecunde
        animator.repeatMode = ValueAnimator.REVERSE
        animator.repeatCount = ValueAnimator.INFINITE

        animator.addUpdateListener {
            // Actualizarea numarului de cadre pentru fiecare cadru de animatie
            frameCount++

            // Invalidarea imageView la fiecare cadru pentru a declansa o redesenare
            imageView.translationX = it.animatedValue as Float
            imageView.invalidate()
        }
        animator.start()
        // Start time pentru calculul FPS
        startTime = System.nanoTime()
        // Programarea(schedule) calculului FPS la fiecare secunda
        calculateFps()
    }

    private fun calculateFps() {
        // Calculare FPS in fiecare secunda
        val currentTime = System.nanoTime()
        val elapsedTime = currentTime - startTime
        val fps = (frameCount * 1e9f)/ elapsedTime

        result.text = "FPS: $fps"
        // Resetarea valorilor pentru urmatoarea secunda
        frameCount = 0
        startTime = currentTime

        // Programarea(schedule) a urmatorului calcul FPS dupa o secunda
        imageView.postDelayed({ calculateFps() }, 1000)
    }

}