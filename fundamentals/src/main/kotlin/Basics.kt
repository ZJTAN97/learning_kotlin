fun main(args : Array<String>) {
    println("Hello World")
    println(5+5)

    // Kotlin Variables
    val name = "Docker"
    val age = 13

    val doubleNumber: Double = 8.0 / 5.0
    val floatNumber = 20F/8F

    println(floatNumber)
    println(doubleNumber)

    println("the value of name is: $name and age: $age")

    // similar to const in javascript where it cannot be reassigned
    val dateCreated = "2023-01-01"


    val userInput = readLine();
    println("You entered $userInput")


    val myArray = arrayOf(13, 14, 15, 16)
    val list = mutableListOf(1, 2, 3)

    list[0] = 2

}