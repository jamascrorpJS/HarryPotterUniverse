package com.jamascrorp.harrypotteruniverse.presentation.FragmentGame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.jamascrorp.harrypotteruniverse.databinding.FragmentGameBinding
import com.jamascrorp.harrypotteruniverse.domain.SaveClickOnTrueFalse
import com.jamascrorp.harrypotteruniverse.presentation.GameVoice
import com.jamascrorp.harrypotteruniverse.presentation.di.injector
import javax.inject.Inject

class GameFragment : Fragment() {

    private var viewBinding: FragmentGameBinding? = null
    private val binding get() = viewBinding!!

    @Inject
    lateinit var viewModel: GameFragmentViewModelDI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as injector).createGameSubComponent()
            .inject(this)
        activity?.startService(GameVoice.intent(activity?.applicationContext!!))
        onBackPressFc()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = FragmentGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getQuestionToPresentation()

        viewModel.questionLiveDats.observe(viewLifecycleOwner) {
            binding.question.text = it.question
            binding.imageGame.setImageBitmap(it.image)
        }

        binding.buttonTrue.setOnClickListener {
            index()
            viewModel.cheked(true)
            viewModel.getClicks(true)
        }

        binding.buttonFalse.setOnClickListener {
            index()
            viewModel.cheked(false)
            viewModel.getClicks(false)
        }
    }

    override fun onPause() {
        super.onPause()
        stopService()
    }

    override fun onStop() {
        super.onStop()
        stopService()
    }

    private fun index() {
        when (viewModel.index) {
            in 0..11 -> viewModel.index++
            12 -> nextQuestion()
            else -> throw Exception("Array index is exception")
        }
    }

    private fun nextQuestion() {
        val args = viewModel.result
        val action = GameFragmentDirections.actionGameFragmentToResultFragment(args)
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun onBackPressFc() {
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                SaveClickOnTrueFalse.listOfClicks.clear()
                isEnabled = false
                activity?.onBackPressed()
            }
        })
    }

    private fun stopService() {
        activity?.stopService(GameVoice.intent(activity?.applicationContext!!))
    }
}
