package ru.technopark.hometask1.view.numberdetail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.technopark.hometask1.databinding.FragmentNumberDetailBinding

class NumberDetailFragment : Fragment() {

    private lateinit var viewBinding: FragmentNumberDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentNumberDetailBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val num = it.getInt(VALUE_ARG_NAME)
            val color = if (num % 2 == 0) Color.RED else Color.BLUE

            viewBinding.numberText.text = num.toString()
            viewBinding.numberText.setTextColor(color)
        }
    }

    companion object {
        private const val VALUE_ARG_NAME = "value"

        fun newInstance(value: Int): NumberDetailFragment {
            val fragment =
                NumberDetailFragment()

            val args = Bundle()
            args.putInt(VALUE_ARG_NAME, value)
            fragment.arguments = args

            return fragment
        }
    }
}