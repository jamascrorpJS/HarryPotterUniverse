package com.jamascrorp.harrypotteruniverse.presentation.FragmentFinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.databinding.FragmentFinalBinding
import com.jamascrorp.harrypotteruniverse.domain.SaveClickOnTrueFalse
import com.jamascrorp.harrypotteruniverse.presentation.GameVoice
import com.jamascrorp.harrypotteruniverse.presentation.recyclerview.adapters.FinalFragmentAdapter

class FinalFragment : Fragment() {


    private var viewBinding: FragmentFinalBinding? = null
    private val binding get() = viewBinding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = FragmentFinalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = context?.applicationContext
        val adapter = context?.let { FinalFragmentAdapter(it) }
        binding.recycler.adapter = adapter
        binding.exit.setOnClickListener {
            findNavController().navigate(R.id.action_finalFragment_to_fragment)
            clicksClear()
            activity?.stopService(GameVoice.intent(activity?.applicationContext!!))
        }
    }

    private fun clicksClear() {
        SaveClickOnTrueFalse.listOfClicks.clear()
    }
}