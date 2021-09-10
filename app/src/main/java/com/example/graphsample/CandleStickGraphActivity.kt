package com.example.graphsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.graphics.Color

import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.data.CandleData

import android.graphics.Paint
import android.util.Log
import android.widget.Toast

import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener


class CandleStickGraphActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candle_stick_graph)

        setupCandleStick()

    }

    private fun setupCandleStick() {
        val candleStickChart = this.findViewById<CandleStickChart>(R.id.candle_stick_chart)
        candleStickChart.isHighlightPerDragEnabled = true

//        candleStickChart.setDrawBorders(true)
//
//        candleStickChart.setBorderColor(resources.getColor(R.color.gray))

        val yAxis = candleStickChart.axisLeft
        val rightAxis = candleStickChart.axisRight
        yAxis.setDrawGridLines(false)
        rightAxis.setDrawGridLines(false)
        candleStickChart.requestDisallowInterceptTouchEvent(true)

        val xAxis = candleStickChart.xAxis

        xAxis.setDrawGridLines(false) // disable x axis grid lines

        xAxis.setDrawLabels(false)
        rightAxis.textColor = Color.WHITE
        yAxis.setDrawLabels(false)
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true
        xAxis.setAvoidFirstLastClipping(true)

        val l = candleStickChart.legend
        //l.isEnabled = false
        val set1 = CandleDataSet(GraphData.candleData, "DataSet 1")
        //set1.color = Color.rgb(80, 80, 80)
        set1.shadowColor = resources.getColor(R.color.gray)
        set1.shadowWidth = 1f
        set1.decreasingColor = resources.getColor(R.color.red)
        set1.decreasingPaintStyle = Paint.Style.FILL
        set1.barSpace = 1f
        set1.highlightLineWidth = 1f
       // set1.formLineWidth = 1f
        set1.increasingColor = resources.getColor(R.color.green)
        set1.increasingPaintStyle = Paint.Style.FILL
        set1.neutralColor = Color.LTGRAY
        set1.setDrawValues(false)

        val data = CandleData(set1)
        candleStickChart.data = data

        candleStickChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                //update textViews
                if(e is CandleEntry) {
                    Log.e("", "onValueSelected12: ${e.open} :: ${e.close} :: ${e.high} :: ${e.low}")
                    Toast.makeText(this@CandleStickGraphActivity, "${e.open} :: ${e.close} :: ${e.high} :: ${e.low}", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onNothingSelected() {

            }

        })
        candleStickChart.invalidate()
    }
}