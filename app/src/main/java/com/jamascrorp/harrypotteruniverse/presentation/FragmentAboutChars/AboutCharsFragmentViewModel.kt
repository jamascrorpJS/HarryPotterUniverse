package com.jamascrorp.harrypotteruniverse.presentation.FragmentAboutChars

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jamascrorp.harrypotteruniverse.data.GameUseCaseRepositoryImpl
import com.jamascrorp.harrypotteruniverse.data.network.Person
import com.jamascrorp.harrypotteruniverse.domain.usecases.GetPersonUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutCharsFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val repository = GameUseCaseRepositoryImpl(application)
    private val getPerson = GetPersonUseCase(repository)
    val liveData = MutableLiveData<List<Person>>()

    private fun getPerson(): Call<List<Person>> {
        return getPerson.invoke()
    }


    fun getResponse() {
        getPerson().enqueue(object : Callback<List<Person>> {
            override fun onResponse(
                call: Call<List<Person>>,
                response: Response<List<Person>>,
            ) {
                if (response.isSuccessful) {
                    val response = response.body()!!
                    liveData.postValue(response)
                    println(Thread.currentThread())
                }
            }

            override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                t.message
            }
        })
    }
}