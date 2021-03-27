package ru.technopark.hometask1.view.numbers

import android.graphics.Color
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.technopark.hometask1.common.NumberItemInteractions
import ru.technopark.hometask1.databinding.NumberItemBinding

class ListNumbersViewHolder(itemView: NumberItemBinding) : RecyclerView.ViewHolder(itemView.root) {
    private val number: TextView = itemView.number

    fun bind(item: Int, numberItemInteractions: NumberItemInteractions) {
        number.text = item.toString()
        val color = if (item % 2 == 0) Color.RED else Color.BLUE
        number.setTextColor(color)

        itemView.setOnClickListener {
            numberItemInteractions.navigateToNumberDetail(item)
        }
    }
}