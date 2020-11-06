package com.example.michishirube.ui.naviDestination

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startForegroundService
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.michishirube.NotificationService
import com.example.michishirube.R
import com.example.michishirube.databinding.FragmentNaviDestinationBinding
import com.example.michishirube.ui.NavigationSharedViewModel


class NaviDestinationFragment : Fragment() {
    private lateinit var binding: FragmentNaviDestinationBinding
    private val sharedViewModel: NavigationSharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNaviDestinationBinding.inflate(inflater, container, false)

        val destinationNameObserver = Observer<String>{newName ->
            binding.tvDesc.text = newName
        }

        sharedViewModel.spotName.observe(this,destinationNameObserver)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //ここにいくボタンを押下
        binding.ibGo.setOnClickListener{
            startActivity(sharedViewModel.intentDestination())
            findNavController().navigate(R.id.action_naviDestination_to_naviNavigating)
            val serviceIntent = Intent(activity, NotificationService::class.java)
            activity?.startForegroundService(serviceIntent)

        }

//        binding.btReload.setOnClickListener {
//            //更新ボタン
//        }
    }


}