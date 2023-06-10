package com.example.test_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_api.adapter.MyAdapter
import com.example.test_api.databinding.ActivityMainBinding
import com.example.test_api.model.Post
import com.example.test_api.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setupRecyclerview()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val myPost = Post(2, 2, "ahmed elsabagh", "i ama android developer")
        viewModel.pushPost(myPost)
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.i("Response", response.body().toString())
                binding.textTitle.text = response.body().toString()
                Log.i("Response", response.code().toString())
                Log.i("Response", response.message())


            } else {
                Log.i("Response", response.errorBody().toString())
                binding.textTitle.text = response.code().toString()

            }
        })

//        val options: HashMap<String, String> = HashMap()
//        options["_sort"] = "id"
//        options["_order"] = "desc"
//        binding.button.setOnClickListener {
//            val myNumber = binding.editTextNumber.text.toString()
//            viewModel.getCustomPostQ2(Integer.parseInt(myNumber), options)
//            viewModel.myResponseCustom.observe(this, Observer { response ->
//                if (response.isSuccessful) {
//                    response.body()?.let { myAdapter.setData(it) }// return all content
//                } else {
//                    Log.i("Response", response.errorBody().toString())
//                    binding.textTitle.text = response.code().toString()
//
//                }
//            })
//        }
    }

    private fun setupRecyclerview() {
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

}