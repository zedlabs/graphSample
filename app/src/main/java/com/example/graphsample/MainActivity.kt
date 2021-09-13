package com.example.graphsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val candleStickGraphButton: Button = findViewById(R.id.candlestick_btn)
        val combinedGraphButton: Button = findViewById(R.id.combined_graph_btn)
        val lineChartButton: Button = findViewById(R.id.line_chart_button)

        candleStickGraphButton.setOnClickListener {
            startActivity(Intent(this, CandleStickGraphActivity::class.java))
        }

        combinedGraphButton.setOnClickListener {
            startActivity(Intent(this, CombinedChartActivity::class.java))
        }

        lineChartButton.setOnClickListener {
            startActivity(Intent(this, LineChartActivity::class.java))
        }
    }
}