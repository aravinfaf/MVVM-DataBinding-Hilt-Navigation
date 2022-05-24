package com.aravind.mvvm.ui.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aravind.mvvm.data.model.UserModel
import com.aravind.mvvm.databinding.FragmentUserBinding
import com.aravind.mvvm.ui.view.adapter.UserAdapter
import com.aravind.mvvm.ui.viewmodel.UserViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : Fragment() {

    private var binding : FragmentUserBinding? = null
    private val viewmodel : UserViewmodel by viewModels()
    private var adapter : UserAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.mUserResponse.observe(viewLifecycleOwner,onUserResponse)
        viewmodel.getUsers()
    }

    private val onUserResponse = Observer<List<UserModel>>{
        binding?.apply {
            userRecyclerview.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = UserAdapter(it)
            userRecyclerview.adapter = adapter
        }
    }
}