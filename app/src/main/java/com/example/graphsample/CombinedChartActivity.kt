package com.example.graphsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.CombinedChart

import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*

import kotlin.collections.MutableMap.MutableEntry
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder
import com.github.mikephil.charting.data.CombinedData

import com.github.mikephil.charting.components.AxisBase

import com.github.mikephil.charting.formatter.IAxisValueFormatter

import com.github.mikephil.charting.components.XAxis.XAxisPosition

import com.github.mikephil.charting.components.XAxis

import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.formatter.ValueFormatter

class CombinedChartActivity : AppCompatActivity() {
    val count = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combined_chart)

        initCombinedChart()
    }

    private fun initCombinedChart() {
        val chart = this.findViewById<CombinedChart>(R.id.chart)

        chart.description.isEnabled = false
        chart.setBackgroundColor(Color.WHITE)
        chart.setDrawGridBackground(false)
        chart.setDrawBarShadow(false)
        chart.isHighlightFullBarEnabled = false
        //    chart.getXAxis().setSpaceMax(.1f);
        //possible values: DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.CANDLE, DrawOrder.LINE, DrawOrder.SCATTER
        chart.drawOrder = arrayOf(DrawOrder.BAR, DrawOrder.LINE)


        val l = chart.legend
        l.isWordWrapEnabled = true
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)
        l.isEnabled = false

        val rightAxis = chart.axisRight
        rightAxis.axisLineColor = Color.WHITE
        rightAxis.setDrawGridLines(false)
        //rightAxis.axisMinimum = 0f // this replaces setStartAtZero(true)


        val leftAxis = chart.axisLeft
        leftAxis.setDrawGridLines(false)
       leftAxis.isEnabled = false
        //leftAxis.axisMinimum = 0f // this replaces setStartAtZero(true)


        val xAxis = chart.xAxis
        xAxis.position = XAxisPosition.BOTTOM
        xAxis.axisMinimum = 0f
        xAxis.granularity = 1f
        xAxis.setDrawGridLines(false)
        xAxis.axisLineColor = Color.WHITE
        //xAxis.setValueFormatter(IAxisValueFormatter { value, axis -> months.get(value.toInt() % months.length) })
        xAxis.valueFormatter = object: ValueFormatter() {

        }

        val data = CombinedData()
        val barData = generateBarData()
        //barData.barWidth = .2f
        data.setData(barData)
        data.setData(generateLineData())

        //data.setValueTypeface(tfLight)

        xAxis.axisMaximum = data.xMax + .99f

        chart.data = data
        chart.marker = CombinedChartMarkerView(this, R.layout.combined_chart_marker_view, listOf())
        chart.invalidate()


    }

    private fun generateLineData(): LineData {
        val d = LineData()

        val entries = mutableListOf<Entry>()
        for(i in 0 until count) entries.add(Entry(i.toFloat(),(-7..15).random().toFloat()))

        val set = LineDataSet(entries, "Line DataSet")
        set.color = resources.getColor(R.color.line1)
        set.lineWidth = 2.5f
//        set.setCircleColor(Color.rgb(240, 238, 70))
//        set.circleRadius = 5f
       // set.fillColor = Color.rgb(240, 238, 70)
        //set.mode = LineDataSet.Mode.
        //set.setDrawValues(true)
        set.valueTextSize = 10f
        set.valueTextColor = Color.rgb(240, 238, 70)
        set.setDrawValues(false)
        //check
        set.axisDependency = YAxis.AxisDependency.RIGHT
        set.setDrawCircles(false)
        set.lineWidth = 1.6f
        d.addDataSet(set)
        return d
    }

    private fun generateBarData(): BarData {
        val entries1: ArrayList<BarEntry> = ArrayList()
        val entries2: ArrayList<BarEntry> = ArrayList()
        for (index in 0 until count) {
            entries1.add(BarEntry(index.toFloat(),(10..25).random().toFloat()))
            entries2.add(BarEntry(index.toFloat(),(-7..-2).random().toFloat()))
        }
        val set1 = BarDataSet(entries1, "Bar 1")
        set1.color = resources.getColor(R.color.bar1)
        set1.valueTextColor = Color.rgb(60, 220, 78)
        set1.valueTextSize = 10f
        set1.axisDependency = YAxis.AxisDependency.RIGHT
        set1.setDrawValues(false)
        val set2 = BarDataSet(entries2, "")
        set2.stackLabels = arrayOf("Stack 1", "Stack 2")
        set2.color = resources.getColor(R.color.bar2)
        set2.valueTextColor = Color.rgb(61, 165, 255)
        set2.valueTextSize = 10f
        set2.axisDependency = YAxis.AxisDependency.RIGHT
        set2.setDrawValues(false)
        val groupSpace = .46f
        val barSpace = 0.02f // x2 dataset
        val barWidth = 0.25f // x2 dataset
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"
        val d = BarData(set1, set2)
        d.barWidth = barWidth
        //d.getGroupWidth()
        // make this BarData object grouped
        d.groupBars(-.24f, groupSpace, barSpace) // start at x = 0
        return d
    }
}