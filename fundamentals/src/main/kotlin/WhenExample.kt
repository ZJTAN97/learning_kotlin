fun main() {

    val age = readLine()?.toInt()

    when(age) {
        in 0..5 -> println("You are a young kid")
        in 6..17 -> println("You are a teenager")
        18 -> println("Going to be adult")
    }

}