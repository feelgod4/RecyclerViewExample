package ru.technopark.hometask1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.technopark.hometask1.R
import ru.technopark.hometask1.view.numbers.ListNumbersFragment
import ru.technopark.hometask1.common.ListNumbersSingleton
import ru.technopark.hometask1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        if (savedInstanceState == null)
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, ListNumbersFragment.newInstance())
                    .commit()
        else
            ListNumbersSingleton.restoreState(savedInstanceState.getInt(SIZE_LIST_SINGLETON))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (!isChangingConfigurations)
            outState.putInt(SIZE_LIST_SINGLETON, ListNumbersSingleton.getSize())
    }

    companion object {
        private const val SIZE_LIST_SINGLETON = "size"
    }
}