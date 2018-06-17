package com.example.edisonliao.jetpackdemo.adapter

import android.support.v7.util.DiffUtil
import com.example.edisonliao.jetpackdemo.model.User

/**
 * Created by EdisonLiao on 2018/6/16.
 */
class UserDiffCallBack : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(p0: User, p1: User): Boolean {
        return p0.name.equals(p1.name)
    }

    override fun areContentsTheSame(p0: User, p1: User): Boolean {
        return p0 == p1
    }
}