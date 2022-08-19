package com.jamascrorp.harrypotteruniverse.data.network

import com.google.gson.annotations.SerializedName

data class Person(
    var name: String?,
    @SerializedName("alternate_names")
    var alternateNames: List<String>,
    var species: String?,
    var gender: String?,

    var house: String?,
    @SerializedName("dateOfBirth")
    var dateBirth: String?,
    @SerializedName("yearOfBirth")
    var yearBirth: Any?,
    @SerializedName("wizard")
    var wizards: Boolean,
    var ancestry: String?,
    var wand: Wand?,
    var patronus: String?,
    var hogwartsStudent: Boolean,
    var hogwartsStaff: Boolean,
    var actor: String?,
    var alive: Boolean,
    var image: String?,
)