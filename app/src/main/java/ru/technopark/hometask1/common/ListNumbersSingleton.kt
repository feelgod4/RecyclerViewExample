package ru.technopark.hometask1.common

object ListNumbersSingleton {
    private const val startSize = 100
    private val mData: MutableList<Int>

    fun takeData(): List<Int> = mData

    fun getSize(): Int {
        return mData.size
    }

    fun addNumber(i: Int) {
        mData.add(i)
    }

    fun restoreState(size: Int) {
        for (i in (startSize + 1)..size)
            mData.add(i)
    }

    init {
        mData = ArrayList()
        for (i in 1..startSize)
            mData.add(i)
    }
}