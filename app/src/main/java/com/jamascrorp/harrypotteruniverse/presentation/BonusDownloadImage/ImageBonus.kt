package com.jamascrorp.harrypotteruniverse.presentation.BonusDownloadImage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.jamascrorp.harrypotteruniverse.databinding.BonusImageFragmentBinding
import com.jamascrorp.harrypotteruniverse.domain.entity.ImageList
import com.jamascrorp.harrypotteruniverse.presentation.recyclerview.adapters.ImageBonusAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ImageBonus : Fragment() {
    private var viewBinding: BonusImageFragmentBinding? = null
    private val binding get() = viewBinding!!
    private lateinit var db: FirebaseFirestore
    private lateinit var adapter: ImageBonusAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = BonusImageFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFromFire()
        adapter = ImageBonusAdapter()
        binding.recycle1.adapter = adapter
        adapter.select = {
            val action = ImageBonusDirections.actionImageBonusToImage(it)
            findNavController().navigate(action)
        }
    }

    private fun getFromFire() {
        CoroutineScope(IO).launch {
            binding.progressBar.visibility = View.VISIBLE
            db = FirebaseFirestore.getInstance()
            db.collection("Glide")
                .get()
                .addOnSuccessListener {
                    for (document in it) {
                        val value: MutableList<ImageList> = it.toObjects(ImageList::class.java)
                        adapter.submitList(value)
                        binding.progressBar.visibility = View.GONE
                    }
                }
        }
    }
}