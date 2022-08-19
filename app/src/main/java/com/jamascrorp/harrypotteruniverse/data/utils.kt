package com.jamascrorp.harrypotteruniverse.data

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.IOException
import java.io.InputStream

fun Context.assetsBitmap(path: String): Bitmap? {
    val inputStream: InputStream
    var bitmap: Bitmap? = null
    try {
        inputStream = assets.open(path)
        bitmap = BitmapFactory.decodeStream(inputStream)
    } catch (e: IOException) {
        Log.d("Exception", "${e.message}")
    }
    return bitmap
}