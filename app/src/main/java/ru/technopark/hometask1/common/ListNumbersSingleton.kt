package ru.technopark.hometask1.common

import ru.technopark.hometask1.model.Number

object ListNumbersSingleton {
    private val mData: MutableList<Number>
    val data: List<Number>
        get() = mData

    fun addNumber(i: Int) {
        mData.add(Number(i))
    }

    fun restoreState(size: Int) {
        for (i in 101..size)
            mData.add(Number(i))
    }

    init {
        mData = ArrayList()
        for (i in 1..100)
            mData.add(Number(i))
    }
}