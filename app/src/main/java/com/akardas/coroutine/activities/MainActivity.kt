package com.akardas.coroutine.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.akardas.coroutine.Dialog
import com.akardas.coroutine.ViewModelFactory
import com.akardas.coroutine.databinding.ActivityMainBinding
import com.akardas.coroutine.databinding.PopupDialogBinding
import com.akardas.coroutine.networking.models.*
import com.akardas.coroutine.retrofit.RetrofitBuilder
import com.akardas.coroutine.retrofit.Status
import com.akardas.coroutine.viewModels.MainViewModel
import com.github.hariprasanths.bounceview.BounceView


class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, ViewModelFactory(RetrofitBuilder.apiService))[MainViewModel::class.java]







        val data1 = LoginDataModel("Abdulah","Android Developer")
        val data2 = LoginDataModel("Adam","Journalist")
        val data3 = LoginDataModel("Mary","Analyst")


        BounceView.addAnimTo(binding.btn1)
        BounceView.addAnimTo(binding.btn2)
        BounceView.addAnimTo(binding.btn3)
        BounceView.addAnimTo(binding.btn4)
        BounceView.addAnimTo(binding.btn5)

        binding.btn1.setOnClickListener {
            observeAllUsers{success, e ->
                val bindingDialog = PopupDialogBinding.inflate(layoutInflater)
                Dialog.PopUpDialog(this,bindingDialog){alertDialog ->
                    if (success != null){
                        bindingDialog.textDialog.text = success.toString()
                    }else if (e != null){
                        bindingDialog.textDialog.text = e.message.toString()
                    }
                    alertDialog.show()
                    BounceView.addAnimTo(bindingDialog.OkBtn)
                    bindingDialog.OkBtn.setOnClickListener {
                        alertDialog.dismiss()
                    }
                }

            }
        }

        binding.btn2.setOnClickListener {
            getSingleUser(2){success, e ->
                val bindingDialog = PopupDialogBinding.inflate(layoutInflater)
                Dialog.PopUpDialog(this,bindingDialog){alertDialog ->
                    if (success != null){
                        bindingDialog.textDialog.text = success.toString()
                    }else if (e != null){
                        bindingDialog.textDialog.text = e.message.toString()
                    }
                    alertDialog.show()
                    BounceView.addAnimTo(bindingDialog.OkBtn)
                    bindingDialog.OkBtn.setOnClickListener {
                        alertDialog.dismiss()
                    }
                }

            }
        }

        binding.btn3.setOnClickListener {
            observeRegisteredUser(data1){ success, e ->
                val bindingDialog = PopupDialogBinding.inflate(layoutInflater)
                Dialog.PopUpDialog(this,bindingDialog){alertDialog ->
                    if (success != null){
                        bindingDialog.textDialog.text = success.toString()
                    }else if (e != null){
                        bindingDialog.textDialog.text = e.message.toString()
                    }
                    alertDialog.show()
                    BounceView.addAnimTo(bindingDialog.OkBtn)
                    bindingDialog.OkBtn.setOnClickListener {
                        alertDialog.dismiss()
                    }
                }

            }
        }

        binding.btn4.setOnClickListener {
            updateUser(data2,4){ success, e ->
                val bindingDialog = PopupDialogBinding.inflate(layoutInflater)
                Dialog.PopUpDialog(this,bindingDialog){alertDialog ->
                    if (success != null){
                        bindingDialog.textDialog.text = success.toString()
                    }else if (e != null){
                        bindingDialog.textDialog.text = e.message.toString()
                    }
                    alertDialog.show()
                    BounceView.addAnimTo(bindingDialog.OkBtn)
                    bindingDialog.OkBtn.setOnClickListener {
                        alertDialog.dismiss()
                    }
                }

            }
        }

        binding.btn5.setOnClickListener {
            updateUserWithPatch(data3){ success, e ->
                val bindingDialog = PopupDialogBinding.inflate(layoutInflater)
                Dialog.PopUpDialog(this,bindingDialog){alertDialog ->
                    if (success != null){
                        bindingDialog.textDialog.text = success.toString()
                    }else if (e != null){
                        bindingDialog.textDialog.text = e.message.toString()
                    }
                    alertDialog.show()
                    BounceView.addAnimTo(bindingDialog.OkBtn)
                    bindingDialog.OkBtn.setOnClickListener {
                        alertDialog.dismiss()
                    }
                }

            }
        }


        setContentView(binding.root)
    }

    private fun observeAllUsers(result:(success:UserModel?,e:Exception?) ->Unit){
        viewModel.getUsers().observe(this) {
            it?.let {resources ->
                when (resources.status){
                    Status.SUCCESS -> {
                        result.invoke(resources.data,null)
                        //binding.myText.text = resources.data.toString()
                    }
                    Status.ERROR -> {
                        result.invoke(null,resources.exception)
                        Log.i("dsfsfs", "ERROR: ${resources.exception?.localizedMessage}")
                    }
                    else -> {
                        Log.i("dsfsfs", "onCreate: ${resources.status}")
                    }
                }
            }
        }
    }

    private fun observeRegisteredUser(dataModel: LoginDataModel,result:(success:RegisModel?,e:Exception?) ->Unit){
        viewModel.registerUser(dataModel).observe(this) {res ->
            res?.let {
                when(it.status){
                    Status.SUCCESS -> {
                        result.invoke(it.data,null)
                        Log.i("wwerwr", "SUCCESS:${it.data} ")
                    }
                    Status.ERROR -> {
                        result.invoke(null,it.exception)
                        Log.i("wwerwr", "ERROR:${it.exception?.localizedMessage} ")
                    }
                    else -> {
                        Log.i("wwerwr", "LOADING:${it.status} ")
                    }
                }
            }
        }
    }

    private fun getSingleUser(userID:Int,result:(success:SingleUserModel?,e:Exception?) ->Unit){
        viewModel.getSingleUser(userID).observe(this){res ->
            res?.let {
                when (it.status){
                    Status.SUCCESS -> {
                        result.invoke(it.data,null)
                        Log.i("ssfsfw", "getSingleUser: ${it.data}")
                    }
                    Status.ERROR -> {
                        result.invoke(null,it.exception)
                        Log.i("ssfsfw", "getSingleUser: ${it.exception?.localizedMessage}")
                    }
                    else -> {
                        Log.i("ssfsfw", "getSingleUser: ${it.status}")
                    }
                }
            }
        }
    }

    private fun updateUser(dataModel: LoginDataModel,userID: Int,result:(success:UpdateUserModel?,e:Exception?) ->Unit){
        viewModel.updateUser(dataModel,userID).observe(this){
            it?.let {
                when (it.status){
                    Status.SUCCESS -> {
                        result.invoke(it.data,null)
                        Log.i("updateUser", "updateUser: ${it.data}")
                    }
                    Status.ERROR -> {
                        result.invoke(null,it.exception)
                        Log.i("updateUser", "updateUser: ${it.exception?.localizedMessage}")
                    }
                    else -> {
                        Log.i("updateUser", "updateUser: ${it.status}")
                    }
                }
            }
        }
    }

    private fun updateUserWithPatch(dataModel: LoginDataModel,result:(success:UpdateUserModel?,e:Exception?) ->Unit){
        viewModel.updateUserWithPath(dataModel).observe(this){
            it?.let {
                when (it.status){
                    Status.SUCCESS -> {
                        result.invoke(it.data,null)
                        Log.i("updateUserWithPatch", "SUCCESS: ${it.data}")
                    }
                    Status.ERROR -> {
                        result.invoke(null,it.exception)
                        Log.i("updateUserWithPatch", "ERROR: ${it.exception?.localizedMessage}")
                    }
                    else -> {
                        Log.i("updateUserWithPatch", "LOADING: ${it.status}")
                    }
                }
            }
        }
    }



}