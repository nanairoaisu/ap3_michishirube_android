package com.example.michishirube.ui.spotList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.michishirube.R
import com.example.michishirube.databinding.FragmentSpotListBinding


class SpotListFragment : Fragment() {

    private val spotListViewModel: SpotListViewModel by viewModels()
    private lateinit var binding: FragmentSpotListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSpotListBinding.inflate(inflater, container, false)

        binding.lvSpot.adapter = RecyclerSpotAdapter()

        val layout = LinearLayoutManager(context)
        binding.lvSpot.layoutManager = layout

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddSpot.setOnClickListener{
            findNavController().navigate(R.id.action_spotList_to_spotRegister)
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.titleFragment)
        }

    }

}