package com.duvivier.clement.model

data class Player (
    val name: String,
    val number: Int,
    val photo: String,
    val position: String,
    val date_of_birth: String,
    val years_pro: String,
    val country: String,
    val height: Height,
    val weight: Weight
)