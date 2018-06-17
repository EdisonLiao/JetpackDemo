package com.example.edisonliao.jetpackdemo.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.support.v7.recyclerview.extensions.ListAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.support.v7.widget.AppCompatCheckBox
import android.view.View
import com.example.edisonliao.jetpackdemo.R
import com.example.edisonliao.jetpackdemo.databinding.ItemListBinding
import com.example.edisonliao.jetpackdemo.model.User
import com.example.edisonliao.jetpackdemo.viewmodel.UserViewModel

/**
 * Created by EdisonLiao on 2018/6/16.
 */
class UserAdapter(viewModel: UserViewModel): ListAdapter<User, UserAdapter.ViewHolder>(UserDiffCallBack()) {

    private val clickListener = View.OnClickListener{ view ->
        viewModel.addUser()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_list,parent,false
                )
        );
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val u = getItem(position)
        holder.apply {
            bind(u,clickListener)
        }
    }


    class ViewHolder(
            private val binding: ItemListBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(item: User,listener:View.OnClickListener){
            binding.apply {
                clickListener = listener
                user = item
                executePendingBindings()
            }
        }

    }

}