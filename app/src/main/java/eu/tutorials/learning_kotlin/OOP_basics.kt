package eu.tutorials.learning_kotlin

import java.lang.IllegalArgumentException

fun main() {
    var devOps = Person("Docker", "Kubernetes", 13)
    devOps.stateHobby()

    var myCar = Car()
    myCar.maxSpeed = 300
    println(myCar.maxSpeed)
}


class Person (firstName: String, lastName: String) {

    // Member Variables - Properties
    var age: Int? = null
    var hobby : String = "Coding or Calisthenics"
    var firstName: String? = null
    var lastName: String? = null

    // Initializer Block
    init {
        this.firstName = firstName
        this.lastName = lastName
        println("Person Created")
    }

    // Member secondary Constructor
    constructor(
        firstName: String,
        lastName: String,
        age: Int
    ): this(firstName, lastName) {
        this.age = age
    }

    // Member Functions - Methods
    fun stateHobby() {
        println("$firstName $lastName hobby is $hobby")
    }
}



class Car() {
    lateinit var owner: String

    val myBrand: String = "BMW"
        // Custom getter
        get() {
            return field.lowercase()
        }

    var maxSpeed: Int = 250
        // Custom getter and setter
        set(value) {
            field = if(value > 0) value else throw IllegalArgumentException("Max speed cannot be less than 0")
        }

    var myModel = "M5"
        private set

    init {
        this.owner = "Eren"
    }
}