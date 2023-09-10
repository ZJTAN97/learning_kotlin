fun main() {

    // Example of vararg usage
    val array = intArrayOf(10, 20, 40, 5000)

    val maxNumber = getMax(10, 100, 1000, *array)
    print("Max number is $maxNumber")

    searchFor("How to learn Kotlin", "ChadGPT")
    searchFor(search = "How to learn android fundamentals")

}

fun searchFor(search: String, searchEngine: String = "Google") {
    println("Your search is: $search")
    println("You search engine is: $searchEngine")
}

fun getMax(vararg numbers: Int): Int {
    // vararg means a "variable number of arguments"
    var max = numbers[0]

    for (number in numbers) {
        if (number > max) {
            max = number
        }
    }

    return max
}