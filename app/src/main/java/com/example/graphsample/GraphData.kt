package com.example.graphsample

import com.github.mikephil.charting.data.CandleEntry

object GraphData {

    val candleData = mutableListOf<CandleEntry>(
//        CandleEntry(0F, 225.0F, 219.84F, 219.94F, 221.07F),
//        CandleEntry(1F, 228.0F, 219.84F, 224.94F, 219.07F),
//        CandleEntry(2F, 226.0F, 219.84F, 221.94F, 224.07F),
//        CandleEntry(3F, 222.0F, 219.84F, 228.94F, 221.07F),
//        CandleEntry(4F, 230.0F, 219.84F, 224.94F, 229.07F),
//        CandleEntry(5F, 225.0F, 219.84F, 219.94F, 221.07F),
//        CandleEntry(6F, 228.0F, 219.84F, 224.94F, 219.07F),
//        CandleEntry(7F, 226.0F, 219.84F, 221.94F, 224.07F),
//        CandleEntry(8F, 222.0F, 219.84F, 228.94F, 221.07F),
//        CandleEntry(9F, 230.0F, 219.84F, 224.94F, 229.07F),
//        CandleEntry(10F, 226.0F, 219.84F, 221.94F, 224.07F),
//        CandleEntry(11F, 222.0F, 219.84F, 228.94F, 221.07F),
//        CandleEntry(12F, 230.0F, 219.84F, 224.94F, 229.07F),
//        CandleEntry(13F, 225.0F, 219.84F, 219.94F, 221.07F),
//        CandleEntry(14F, 228.0F, 219.84F, 224.94F, 219.07F),
//        CandleEntry(15F, 228.0F, 225.84F, 225.94F, 225.07F),
//        CandleEntry(16F, 225.0F, 219.84F, 219.94F, 221.07F),
//        CandleEntry(17F, 228.0F, 219.84F, 224.94F, 219.07F),
//        CandleEntry(18F, 226.0F, 219.84F, 221.94F, 224.07F),
//        CandleEntry(19F, 222.0F, 219.84F, 228.94F, 221.07F),
//        CandleEntry(20F, 230.0F, 219.84F, 224.94F, 229.07F),
//        CandleEntry(21F, 225.0F, 219.84F, 219.94F, 221.07F),
//        CandleEntry(22F, 228.0F, 219.84F, 224.94F, 219.07F),
//        CandleEntry(23F, 226.0F, 219.84F, 221.94F, 224.07F),
//        CandleEntry(24F, 222.0F, 219.84F, 228.94F, 221.07F),
//        CandleEntry(25F, 230.0F, 219.84F, 224.94F, 229.07F),
//        CandleEntry(26F, 226.0F, 219.84F, 221.94F, 224.07F),
//        CandleEntry(27F, 222.0F, 219.84F, 228.94F, 221.07F),
//        CandleEntry(28F, 230.0F, 219.84F, 224.94F, 229.07F),
//        CandleEntry(29F, 225.0F, 219.84F, 219.94F, 221.07F),
//        CandleEntry(30F, 228.0F, 219.84F, 224.94F, 219.07F),
//        CandleEntry(31F, 228.0F, 225.84F, 225.94F, 225.07F),
//        CandleEntry(32F, 225.0F, 219.84F, 219.94F, 221.07F),
//        CandleEntry(33F, 228.0F, 219.84F, 224.94F, 219.07F),
//        CandleEntry(34F, 226.0F, 219.84F, 221.94F, 224.07F),
    ).also {
        for(i in 0..168) {
            if(i%2 == 0) it.add(CandleEntry(i.toFloat(), 225.0F+(0..10).random(), 219.84F+(0..10).random(), 219.94F+(0..10).random(), 221.07F+(0..10).random()))
            else it.add(CandleEntry(i.toFloat(), 228.0F+(0..10).random(), 219.84F+(0..10).random(), 224.94F+(0..10).random(), 219.07F+(0..10).random()))
        }
    }
}