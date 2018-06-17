package com.example.edisonliao.jetpackdemo

import android.arch.lifecycle.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.edisonliao.jetpackdemo.adapter.UserAdapter
import com.example.edisonliao.jetpackdemo.viewmodel.UserViewModel
import com.example.edisonliao.jetpackdemo.viewmodel.UserViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeUi()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun subscribeUi(){
        val factory = UserViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory).get(UserViewModel::class.java)
        val adapter = UserAdapter(viewModel)
        recycler.adapter = adapter

        viewModel.getUserList().observe(this, Observer { result ->
            adapter.submitList(result)
        })
    }

}
