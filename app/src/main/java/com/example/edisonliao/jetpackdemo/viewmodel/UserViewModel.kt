package com.example.edisonliao.jetpackdemo.viewmodel

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import com.example.edisonliao.jetpackdemo.model.User

/**
 * Created by EdisonLiao on 2018/6/16.
 */
class UserViewModel: ViewModel() {

    private val userList = MediatorLiveData<List<User>>()


    fun getUserList(): MediatorLiveData<List<User>>{
        val list = ArrayList<User>()
        for (i in 0..9){
            list.add(User("Im $i",false))
        }

        userList.value = list
        return userList
    }

    fun addUser(): MediatorLiveData<List<User>>{
        val list = userList.value as ArrayList
        val tmpList = ArrayList<User>()
        tmpList.addAll(list)
        tmpList.add(2, User("hehe",true))
        userList.value = tmpList
        return userList
    }


}