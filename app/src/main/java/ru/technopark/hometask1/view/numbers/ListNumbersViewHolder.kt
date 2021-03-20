package ru.technopark.hometask1.view.numbers

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.technopark.hometask1.model.Number
import ru.technopark.hometask1.common.NumberItemInteractions
import ru.technopark.hometask1.databinding.NumberItemBinding

class ListNumbersViewHolder(itemView: NumberItemBinding) : RecyclerView.ViewHolder(itemView.root) {
    private val number: TextView = itemView.number

    fun bind(item: Number, numberItemInteractions: NumberItemInteractions) {
        number.text = item.toString()
        number.setTextColor(item.color)

        itemView.setOnClickListener {
            numberItemInteractions.navigateToNumberDetail(item)
        }
    }
}