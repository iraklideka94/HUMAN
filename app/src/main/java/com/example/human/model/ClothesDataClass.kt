package com.example.human.model

data class ClothesDataClass(
    val content: List<Content>
) {
    data class Content(
        val image: String?,
        val price: String,
        val category: String?
    )
}
