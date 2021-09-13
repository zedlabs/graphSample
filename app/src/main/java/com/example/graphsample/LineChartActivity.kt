package com.example.graphsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.util.ArrayList

class LineChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart)

        val chart = findViewById<LineChart>(R.id.multi_line_chart)

        val dataSets = ArrayList<ILineDataSet>()

        for(i in 0..2) {
            val values = ArrayList<Entry>()
            for(i in 0..3) {
                values.add(Entry(i.toFloat(), 0f+(0..5).random()))
            }

            val d = LineDataSet(values, "")
            d.lineWidth = 1.5f
            d.setDrawCircles(false)
            d.setDrawValues(false)
            when (i) {
                0 -> {d.color = resources.getColor(R.color.bar1)}
                1 -> {d.color = resources.getColor(R.color.bar2)}
                2 -> {d.color = resources.getColor(R.color.line1)}
                else -> {}
            }
            dataSets.add(d)
        }

        val data = LineData(dataSets)

        data.isHighlightEnabled = false
        chart.data = data
        chart.setDrawGridBackground(false)
        chart.description.isEnabled = false
        chart.setDrawBorders(true)
        chart.setBorderColor(ContextCompat.getColor(this, R.color.gray))
        chart.axisLeft.isEnabled = false
        chart.axisRight.setDrawAxisLine(false)
        chart.axisRight.setDrawGridLines(false)
        chart.xAxis.setDrawAxisLine(false)
        chart.xAxis.setDrawGridLines(false)
        chart.setPinchZoom(false)
        chart.setScaleEnabled(false)
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        chart.legend.isEnabled = false
        chart.legend.isWordWrapEnabled = true
        chart.notifyDataSetChanged()
        chart.invalidate()
    }
}