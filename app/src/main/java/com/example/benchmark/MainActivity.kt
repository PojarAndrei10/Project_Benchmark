package com.example.benchmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var cpuBenchmarkButton: Button
    private lateinit var memoryBenchmarkButton: Button
    private lateinit var gpuBenchmarkButton: Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }
    private fun initData()
    {
        cpuBenchmarkButton=findViewById(R.id.cpuBenchmarkButton)
        memoryBenchmarkButton=findViewById(R.id.memoryBenchmarkButton)
        gpuBenchmarkButton=findViewById(R.id.gpuBenchmarkButton)
        handleClick()
    }
    private fun handleClick()
    {
        cpuBenchmarkButton.setOnClickListener{
            startActivity(Intent(this,CpuActivity::class.java))
        }
        memoryBenchmarkButton.setOnClickListener {
            startActivity(Intent(this, MemoryActivity::class.java))
        }
        gpuBenchmarkButton.setOnClickListener {
            startActivity(Intent(this, GpuActivity::class.java))
        }
    }
}