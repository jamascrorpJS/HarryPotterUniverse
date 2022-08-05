package com.jamascrorp.harrypotteruniverse.presentation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.data.GameUseCaseRepositoryImpl
import com.jamascrorp.harrypotteruniverse.presentation.FragmentMain.MainFragment
import com.jamascrorp.harrypotteruniverse.presentation.FragmentResult.ResultFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}