package com.jamascrorp.harrypotteruniverse.presentation.FragmentAboutChars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jamascrorp.harrypotteruniverse.databinding.FragmentAboutBinding
import com.jamascrorp.harrypotteruniverse.presentation.recyclerview.adapters.FragmentAboutAdapter

class AboutCharsFragment : Fragment() {

    private var viewBinding: FragmentAboutBinding? = null

    private val ViewBinding get() = viewBinding!!

    private lateinit var viewModel: AboutCharsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = FragmentAboutBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[AboutCharsFragmentViewModel::class.java]
        return ViewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewBinding.recycle.layoutManager =
            LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)
        viewModel.getResponse()
        viewModel.liveData.observe(viewLifecycleOwner) {
            ViewBinding.recycle.adapter = FragmentAboutAdapter(it)
        }
    }
}
