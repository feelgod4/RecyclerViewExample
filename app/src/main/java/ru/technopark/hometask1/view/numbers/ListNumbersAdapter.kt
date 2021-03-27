package ru.technopark.hometask1.view.numbers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.technopark.hometask1.common.NumberItemInteractions
import ru.technopark.hometask1.databinding.NumberItemBinding

class ListNumbersAdapter(private val numberItemInteractions: NumberItemInteractions, private val inputList : List<Int>): RecyclerView.Adapter<ListNumbersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNumbersViewHolder {
        val viewBinding = NumberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListNumbersViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ListNumbersViewHolder, position: Int) {
        holder.bind(position + 1, numberItemInteractions)
    }

    override fun getItemCount(): Int {
        return inputList.size
    }
}