package com.jamascrorp.harrypotteruniverse.presentation.FragmentAboutChars

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamascrorp.harrypotteruniverse.data.network.Person
import com.jamascrorp.harrypotteruniverse.domain.usecases.GetPersonUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AboutCharsFragmentViewModel @Inject constructor(private val getPersonUseCase: GetPersonUseCase) :
    ViewModel() {

    val liveData = MutableLiveData<List<Person>>()

    private suspend fun getPerson(): Call<List<Person>> {
        return getPersonUseCase.invoke()
    }

    suspend fun getResponse() {
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