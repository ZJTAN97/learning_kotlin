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

    print("Hello $myName")
}
