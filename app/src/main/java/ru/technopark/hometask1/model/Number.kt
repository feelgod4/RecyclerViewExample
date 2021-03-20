package ru.technopark.hometask1.model

import android.graphics.Color

class Number(private val num: Int) {
    val color = if (num % 2 == 0) Color.RED else Color.BLUE

    override fun toString(): String {
        return num.toString()
    }
}