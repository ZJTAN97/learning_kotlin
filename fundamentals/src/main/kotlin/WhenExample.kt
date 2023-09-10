fun main() {

    val age = readLine()?.toInt()

    when (age) {
        in 0..5 -> println("You are a young kid")
        in 6..17 -> println("You are a teenager")
        18 -> println("Going to be adult")
        19, 20 -> println("You are a young adult")
        in 21..65 -> println("You are an adult")
        else -> println("Young senior")
    }

    val base = readLine()?.toInt()
    val exponent = readLine()?.toInt()

    if (base !== null && exponent !== null) {
        val answer = getExponent(base, exponent)
        println(answer)
    }


}

fun getExponent(base: Int, exponent: Int): Int {
    var result = 1
    for (i in 1..exponent) {
        result *= base // result = result * base
    }

    return result
}