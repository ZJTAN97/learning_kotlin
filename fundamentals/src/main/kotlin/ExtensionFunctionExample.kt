fun main() {

  println("Please enter a number")
  val input = readLine()?.toInt()

  if(input != null) {
    val isPrime = input.isPrime()
    if(isPrime) println("You entered a prime number: $input")
    else println("You entered a non-prime number: $input")
  }

}

fun Int.isPrime(): Boolean {
  for( i in 2 until this - 1) {
    if(this % i == 0) {
      return false
    }
  }

  return true
}