package com.example.eggscount.eggscalculator

class EggCalculator {

    // Function to calculate gross, dozen, and unit
    fun calculateEggs(eggs: Int): Triple<Int, Int, Int> {
        val gross = eggs / 144
        val dozen = (eggs % 144) / 12
        val unit = eggs % 12
        return Triple(gross, dozen, unit)
    }
}