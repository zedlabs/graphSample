package com.example.graphsample

import android.content.Context
import android.util.Log
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight


class CombinedChartMarkerView constructor(
    context: Context?,
    layoutResource: Int,
    data: List<CombinedChartData>
) : MarkerView(context, layoutResource) {

    private var tv1: TextView? = null
    private var tv2: TextView? = null
    private var tv3: TextView? = null

    init {
        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        tv3 = findViewById(R.id.tv3)
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        Log.e("", "refreshContent: ${e?.y} :: ${e?.data} :: ${e?.x}")
    }

}