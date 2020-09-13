package com.example.template

class Task1(): Car, Write {
    override fun typeOfCar(): String {
        return "BMW"
    }
    override fun buildYear(): Int {
        return 1980
    }

    override fun dummyWrite() {
        TODO("Not yet implemented")
    }
}