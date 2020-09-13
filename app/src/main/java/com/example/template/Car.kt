package com.example.template

interface Car {
    fun typeOfCar(): String
    fun buildYear(): Int
    fun buildBy() = "I don't know actually who make BMW"
}
interface Write {
    fun dummyWrite()
}