package com.jamascrorp.harrypotteruniverse.presentation.FragmentMain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.databinding.FragmentBinding
import com.jamascrorp.harrypotteruniverse.presentation.BackgroundVoice

class Fragment : Fragment() {
    private var viewBinding: FragmentBinding? = null
    private val binding get() = viewBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.startService(BackgroundVoice.intent(activity?.applicationContext!!))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = FragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.playe.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_to_gameFragment)
        }
        binding.pics.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_to_imageBonus)
        }
        binding.perso.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_to_aboutCharsFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.startService(BackgroundVoice.intent(activity?.applicationContext!!))
    }

    override fun onPause() {
        super.onPause()
        stopService()
    }

    override fun onStop() {
        super.onStop()
        stopService()
    }

    private fun stopService() {
        activity?.stopService(BackgroundVoice.intent(activity?.applicationContext!!))
    }
}