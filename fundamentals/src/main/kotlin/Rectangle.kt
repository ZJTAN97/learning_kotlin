class Rectangle(
    private val length: Double,
    private val width: Double
) : Shape("Rectangle") {

    init {
        println("Name of shape: $name")
        println("Rectangle created with length: $length and width: $width")
    }

    fun area() = length * width

    fun perimeter() = 2 * length + 2 * width

    fun isSquare() = length == width


    var nameOfRectangle: String = ""
}