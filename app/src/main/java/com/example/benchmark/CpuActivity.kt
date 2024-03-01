package com.example.benchmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CpuActivity: AppCompatActivity() {
   private lateinit var result:TextView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cpu)
        initData()
    }
    private fun initData()
    {
        result=findViewById(R.id.tvResult)
        setData()
    }
    private fun setData()
    {
        val elapsedTime=simulateCPUBenchmarkTask()
        val resultCPUBenchmark="CPU Benchmark Time: $elapsedTime ms"
        result.text=resultCPUBenchmark
    }
    private fun simulateCPUBenchmarkTask():Long
    {
        val startTime=System.currentTimeMillis()
        //se efectueaza o bucla mare pt o operatie de multiplicare
        for(i in 0 until 1000000000)
        {
            val result=i*2
        }
        val endTime=System.currentTimeMillis()
        return endTime-startTime
    }
}