package com.akardas.coroutine.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.akardas.coroutine.ViewModelFactory
import com.akardas.coroutine.databinding.ActivityMainBinding
import com.akardas.coroutine.networking.ApiHelper
import com.akardas.coroutine.networking.models.LoginDataModel
import com.akardas.coroutine.retrofit.RetrofitBuilder
import com.akardas.coroutine.retrofit.Status
import com.akardas.coroutine.viewModels.MainViewModel


class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))[MainViewModel::class.java]


        observeAllUsers()
        observeRegisteredUser(LoginDataModel("Abdullah","Bussines administration"))


        binding.clickBtn.setOnClickListener {
            getSingleUser(2)
        }

        setContentView(binding.root)
    }

    private fun observeAllUsers(){
        viewModel.getUsers().observe(this) {
            it?.let {resources ->
                when (resources.status){
                    Status.SUCCESS -> {
                        resources.data?.data?.forEach {res ->
                            Log.i("dsfsfs", "onCreate: ${res.email}")
                        }
                        //binding.myText.text = resources.data.toString()
                    }
                    Status.ERROR -> {
                        Log.i("dsfsfs", "ERROR: ${resources.exception?.localizedMessage}")
                    }
                    else -> {
                        Log.i("dsfsfs", "onCreate: ${resources.status}")
                    }
                }
            }
        }
    }

    private fun observeRegisteredUser(dataModel: LoginDataModel){
        viewModel.registerUser(dataModel).observe(this) {res ->
            res?.let {
                when(it.status){
                    Status.SUCCESS -> {
                        Log.i("wwerwr", "SUCCESS:${it.data} ")
                    }
                    Status.ERROR -> {
                        Log.i("wwerwr", "ERROR:${it.exception?.localizedMessage} ")
                    }
                    else -> {
                        Log.i("wwerwr", "LOADING:${it.status} ")
                    }
                }
            }
        }
    }

    private fun getSingleUser(userID:Int){
        viewModel.getSingleUser(userID).observe(this){res ->
            res?.let {
                when (it.status){
                    Status.SUCCESS -> {
                        Log.i("ssfsfw", "getSingleUser: ${it.data}")
                    }
                    Status.ERROR -> {
                        Log.i("ssfsfw", "getSingleUser: ${it.exception?.localizedMessage}")
                    }
                    else -> {
                        Log.i("ssfsfw", "getSingleUser: ${it.status}")
                    }
                }
            }
        }
    }


}