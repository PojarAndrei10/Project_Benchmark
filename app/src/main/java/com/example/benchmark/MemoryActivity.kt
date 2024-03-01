package com.example.benchmark

import android.os.Build
import android.os.Bundle
import android.os.Debug
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MemoryActivity :AppCompatActivity(){
    private lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)
        initData()
    }
    private fun initData()
    {
        result=findViewById(R.id.tvResult)
        handleMemory()
    }
    private fun handleMemory()
    {
        val startTime=System.currentTimeMillis()
        // Informatii legate de memorie
        val initialMemoryUsage = getMemoryUsage()
        // in MB
        val totalMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024)
        val availableMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024)

        // Simulam o sarcina cu utilizare intensiva a memoriei
        val resultMemoryBenchmark = simulateMemoryBenchmarkTask()

        val endTime = System.currentTimeMillis()
        val elapsedTime = endTime - startTime

        // Android version + API level
        val androidVersion = Build.VERSION.RELEASE
        val apiLevel = Build.VERSION.SDK_INT

        val resultData = "Memory Benchmark Time: $elapsedTime ms\n" +
                "Initial Memory Usage: $initialMemoryUsage MB\n" +
                "Memory Usage During Task: ${initialMemoryUsage - availableMemory} MB\n" +
                "Total RAM: $totalMemory MB\n" +
                "Available RAM: $availableMemory MB\n" +
                "Android Version: $androidVersion (API $apiLevel)\n" +
                "Result: $resultMemoryBenchmark"
        result.text = resultData
    }
    private fun getMemoryUsage():Long{
        val debug= Debug.getNativeHeapAllocatedSize()
        return debug/(1024*1024)  //in MB
    }

    // Simulam o sarcina cu utilizare intensiva a memoriei
    private fun simulateMemoryBenchmarkTask(): Long {
        val startTime = System.currentTimeMillis()
        val array = IntArray(10000000)
        for (i in 0 until 10000000) {
            // Simularea operatiilor de memorie
            array[i] = i
        }
        val endTime = System.currentTimeMillis()
        return endTime - startTime
    }
}