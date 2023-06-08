package com.example.test_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.test_api.databinding.ActivityMainBinding
import com.example.test_api.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.button.setOnClickListener {
            val myNumber = binding.editTextNumber.text.toString()
            viewModel.getPost2(Integer.parseInt(myNumber))
            viewModel.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    binding.textTitle.text = response.body().toString() // return all content
//                    binding.textTitle.text = response.body()?.title // return title only
                } else {
                    Log.i("Response", response.errorBody().toString())
                    binding.textTitle.text = response.code().toString()

                }
            })
        }
    }
}