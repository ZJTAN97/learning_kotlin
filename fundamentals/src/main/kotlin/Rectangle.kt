class Rectangle(
    private val length: Double,
    private val width: Double
) : Shape("Rectangle") {

    var nameOfRectangle: String = ""

    init {
        println("Name of shape: $name")
        println("Rectangle created with length: $length and width: $width")
    }

    override fun area() = length * width
    override fun perimeter() = 2 * length + 2 * width
    fun isSquare() = length == width
    fun getActualArea() = this.area() * ratio

}