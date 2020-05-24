package com.studing.model

data class Store(
    val name: String,
    val address: String? = null,
    val webSite: String,
    val phones: List<Phone>
)