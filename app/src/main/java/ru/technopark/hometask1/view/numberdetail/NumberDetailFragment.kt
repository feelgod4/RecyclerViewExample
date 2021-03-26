package ru.technopark.hometask1.view.numberdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.technopark.hometask1.databinding.FragmentOneNumberBinding
import ru.technopark.hometask1.model.Number

class NumberDetailFragment : Fragment() {

    private lateinit var viewBinding: FragmentOneNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentOneNumberBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            viewBinding.numberText.text = it.getString(VALUE_ARG_NAME)
            viewBinding.numberText.setTextColor(it.getInt(COLOR_ARG_NAME))
        }
    }

    companion object {
        private const val VALUE_ARG_NAME = "value"
        private const val COLOR_ARG_NAME = "color"

        fun newInstance(value: Number): NumberDetailFragment {
            val fragment =
                NumberDetailFragment()

            val args = Bundle()
            args.putString(VALUE_ARG_NAME, value.toString())
            args.putInt(COLOR_ARG_NAME, value.color)
            fragment.arguments = args

            return fragment
        }
    }
}