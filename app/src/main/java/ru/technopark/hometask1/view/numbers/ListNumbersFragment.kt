package ru.technopark.hometask1.view.numbers

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import ru.technopark.hometask1.R
import ru.technopark.hometask1.common.ListNumbersSingleton
import ru.technopark.hometask1.databinding.FragmentListNumbersBinding
import ru.technopark.hometask1.model.Number
import ru.technopark.hometask1.common.NumberItemInteractions
import ru.technopark.hometask1.view.numberdetail.NumberDetailFragment


class ListNumbersFragment : Fragment(), NumberItemInteractions {

    private lateinit var viewBinding: FragmentListNumbersBinding

    companion object {
        fun newInstance(): ListNumbersFragment {
            return ListNumbersFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentListNumbersBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = viewBinding.numbersRecycler
        recyclerView.layoutManager =
            GridLayoutManager(context, resources.getInteger(R.integer.columns_count))

        val recycleViewAdapter = ListNumbersAdapter(this, ListNumbersSingleton.data)
        recyclerView.adapter = recycleViewAdapter

        viewBinding.btnGenerate.setOnClickListener {
            ListNumbersSingleton.addNumber(recycleViewAdapter.itemCount)
            recycleViewAdapter.notifyItemInserted(ListNumbersSingleton.data.size - 1)
        }
    }

    override fun navigateToNumberDetail(number: Number) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.container, NumberDetailFragment.newInstance(number))
            ?.addToBackStack(null)
            ?.commit()
    }
}