package com.jamascrorp.harrypotteruniverse.domain.repository

interface CheckClicksRepository {
    fun checkClicks(index: Int): Boolean

}