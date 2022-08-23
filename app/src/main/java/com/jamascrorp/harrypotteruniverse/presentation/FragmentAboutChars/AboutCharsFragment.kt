package com.jamascrorp.harrypotteruniverse.presentation.FragmentAboutChars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jamascrorp.harrypotteruniverse.databinding.FragmentAboutBinding
import com.jamascrorp.harrypotteruniverse.presentation.di.injector
import com.jamascrorp.harrypotteruniverse.presentation.recyclerview.adapters.FragmentAboutAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AboutCharsFragment : Fragment() {

    private var viewBinding: FragmentAboutBinding? = null

    private val ViewBinding get() = viewBinding!!

    @Inject
    lateinit var viewModel: AboutCharsFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as injector).createFragmentAboutChars()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = FragmentAboutBinding.inflate(inflater, container, false)
        return ViewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewBinding.recycle.layoutManager =
            LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)
        CoroutineScope(IO).launch {
            withContext(Main) {
                viewBinding?.progressbar?.visibility = View.VISIBLE
            }
            viewModel.getResponse()
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            ViewBinding.progressbar.visibility = View.GONE
            ViewBinding.recycle.adapter = FragmentAboutAdapter(it)
        }
    }
}
