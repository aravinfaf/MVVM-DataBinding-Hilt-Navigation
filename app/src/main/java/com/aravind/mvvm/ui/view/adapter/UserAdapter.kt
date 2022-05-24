package com.aravind.mvvm.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aravind.mvvm.R
import com.aravind.mvvm.data.model.UserModel
import com.aravind.mvvm.databinding.ListAdapterBinding
import com.bumptech.glide.Glide

class UserAdapter(private val userList: List<UserModel>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ListAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userModel: UserModel) {
            binding.name.text = userModel.name
            binding.email.text = userModel.email
            Glide.with(binding.avatar.context).load(userModel.avatarUrl).placeholder(R.drawable.ic_launcher_foreground).into(binding.avatar)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        return ViewHolder(
            ListAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size
}