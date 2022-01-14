package eu.tutorials.learning_kotlin

fun main() {
    // var can be overwritten
    // val cannot be overwritten
    val myName: String = "Docker" // immutable

    // kotlin has type inference
    // do not have to specify the type
    val myByte: Byte = 13
    val myShort: Short = 125
    val myInt: Int = 1234123412
    val myLong: Long = 12_039_812_309_314

    val myFloat: Float = 13.37F
    val myDouble: Double = 3.14

    var myBoolean: Boolean = true

    var letterChar: Char = 'A'

    // Strings
    var myString: String = "sample string"
    var firstCharInStr = myString[0]
    var lastCharInStr = myString[myString.length - 1]

    println("Hello $myName")

    // Arithmetic operators
    var result = 5+3
    result /= 2
    val a = 5.0
    val b = 3.0
    var resultDouble = a / b
    println(result)
    println(resultDouble)
    println("String literals sorta ${5+3}")


    // if else
    val age = 31
    if(age >= 21) {
        println("You are legal.")
    } else if (age >= 18) {
        println("Going adult")
    } else if (age >= 16) {
        println("going poly")
    } else {
        println("amazing times")
    }
    if(age>=21) println("Single liner works here too in Kotlin")


    // when (essentially switch statements)
    var season = 4
    when(season) {
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> println("Autumn")
        4 -> {
            println("Winter")
            println("Merry xmas!")
        }
        else -> println("Invalid season")
    }

    var month = 3
    when(month) {
        in 3..5 -> println("Spring")
        in 6..9 -> println("Autumn")
        in 9..12 -> println("Winter")
        1,2 -> print("Summer")
    }

    when(month) {
        is Int -> println("$month is an integer")
        else -> println("$month not an integer")
    }

}
