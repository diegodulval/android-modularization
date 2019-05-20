package demo.com.dulval.mycomponent.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import demo.com.dulval.mycomponent.R
import androidx.lifecycle.Observer
import demo.com.dulval.mycomponent.databinding.ActivityMainBinding
import demo.com.dulval.mycomponent.feature.list.AndroidJobsListActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.showAndroidJobsLiveData.observe(this, Observer { isShow ->
            when(isShow) {
                true -> { startActivity(AndroidJobsListActivity.launchIntent(this)) }
            }
        })

        viewModel.outputAppLiveData.observe(this, Observer { isOut ->
            when(isOut) {
                true -> { finish() }
            }
        })
    }
}