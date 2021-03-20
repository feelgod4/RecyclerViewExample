package ru.technopark.hometask1.view.numbers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.technopark.hometask1.model.Number
import ru.technopark.hometask1.common.NumberItemInteractions
import ru.technopark.hometask1.databinding.NumberItemBinding

class ListNumbersAdapter(private val numberItemInteractions: NumberItemInteractions, private val inputList : List<Number>): RecyclerView.Adapter<ListNumbersViewHolder>() {
    private var numbersList: List<Number> = inputList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNumbersViewHolder {
        val viewBinding = NumberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListNumbersViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ListNumbersViewHolder, position: Int) {
        val item = Number(position+1)
        holder.bind(item, numberItemInteractions)
    }

    override fun getItemCount(): Int {
        return numbersList.size
    }
}