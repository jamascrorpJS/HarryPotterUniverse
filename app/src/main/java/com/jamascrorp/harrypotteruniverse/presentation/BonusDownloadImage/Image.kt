package com.jamascrorp.harrypotteruniverse.presentation.BonusDownloadImage

import android.content.ContentValues
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.databinding.ImageBinding
import java.io.File

class Image : Fragment() {

    private var viewBinding: ImageBinding? = null
    private val binding get() = viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = ImageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = ImageArgs.fromBundle(requireArguments()).url
        Glide.with(activity?.applicationContext!!)
            .load(url)
            .into(binding.image)
        binding.saveImage.setOnClickListener {
            saveToGallery()
        }
    }

    private fun saveToGallery() {
        val bitmap = binding.image.drawToBitmap()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val resolver = requireActivity().contentResolver
            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, "${System.currentTimeMillis()} + .jpg")
                put(
                    MediaStore.MediaColumns.RELATIVE_PATH,
                    Environment.DIRECTORY_PICTURES + File.separator + "Harry Potter"
                )
                toast()
            }
            val imageUri = resolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues
            )
            val fos = resolver.openOutputStream(imageUri!!)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
        } else {
            oldVers(bitmap)
        }
    }

    private fun oldVers(bitmap: Bitmap) {
        MediaStore.Images.Media.insertImage(
            requireActivity().contentResolver,
            bitmap,
            "Image.jpg",
            null
        )
        toast()
    }

    private fun toast() {
        Toast.makeText(activity?.applicationContext,
            getString(R.string.saveSuccess),
            Toast.LENGTH_SHORT).show()
    }
}