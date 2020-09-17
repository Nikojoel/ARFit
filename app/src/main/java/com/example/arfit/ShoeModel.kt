package com.example.arfit

object ShoeModel {
    val shoes: MutableList<Shoe> = java.util.ArrayList()

    init {
        shoes.add(Shoe("Nike AirForce1", 2131165331, "Stadium", "79.90€-119.00€"))
        shoes.add(Shoe("Nike AirForce2", 2131165332, "JD", "79.90€-119.00€"))
        shoes.add(Shoe("Nike AirForce3", 2131165333, "Athlete's Foot", "79.90€-119.00€"))
    }
}