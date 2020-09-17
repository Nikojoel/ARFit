package com.example.arfit

object ShoeModel {
    val shoes: MutableList<Shoe> = java.util.ArrayList()

    init {
        shoes.add(Shoe("Nike Revolution 5", 2131165331, "Stadium", "39.90-59.99€"))
        shoes.add(Shoe("Custom Revolution 5", 2131165332, "Zalando", "59.99-74.99€"))
    }
}