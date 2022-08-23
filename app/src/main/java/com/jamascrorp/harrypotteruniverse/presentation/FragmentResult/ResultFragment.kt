package com.jamascrorp.harrypotteruniverse.presentation.FragmentResult

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.databinding.FragmentResultBinding
import com.jamascrorp.harrypotteruniverse.presentation.GameVoice
import com.jamascrorp.harrypotteruniverse.presentation.di.injector
import javax.inject.Inject

class ResultFragment : Fragment() {

    private var viewBinding: FragmentResultBinding? = null
    private val binding get() = viewBinding!!

    @Inject
    lateinit var viewModel: FragmentResultViewModel
    private lateinit var animationDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.application as injector).createResultSubComponent()
            .inject(this)
        activity?.startService(GameVoice.intent(activity?.applicationContext!!))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = FragmentResultBinding.inflate(layoutInflater)
        val args = ResultFragmentArgs.fromBundle(requireArguments()).result
        viewModel.resultToPresentation(args)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val veryGood = activity?.resources?.getString(R.string.verygood)
        val good = activity?.resources?.getString(R.string.verygood0)
        val dobbi = activity?.resources?.getString(R.string.dobbi)

        viewModel.LiveData1.observe(viewLifecycleOwner) {
            val text = it.percentOfTrueAnswer.toString() + "%"
            binding.percent.text = text
            when (it.percentOfTrueAnswer) {
                in 90..100 -> {
                    setAnimation(R.drawable.germionax)
                    binding.text.text = veryGood
                }
                in 50..90 -> {
                    setAnimation(R.drawable.germiona)
                    binding.text.text = good
                }
                in 0..50 -> {
                    setAnimation(R.drawable.dobbi)
                    binding.text.text = dobbi
                }
            }
        }
        binding.sele.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_finalFragment)
        }
    }

    private fun setAnimation(res: Int) {
        binding.root.apply {
            setBackgroundResource(res)
            animationDrawable = background as AnimationDrawable
        }
        animationDrawable.start()
    }
}