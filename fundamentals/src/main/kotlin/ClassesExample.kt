fun main() {

    val myRect = Rectangle(15.0, 10.0)

    println(myRect.area())
    println(myRect.perimeter())
    println(myRect.isSquare())

    myRect.nameOfRectangle = "New Rectangle"
    myRect.name = "Rectangle Shape"

    println("Name of rectangle: ${myRect.nameOfRectangle}")
    println("Name of shape: ${myRect.name}")

}