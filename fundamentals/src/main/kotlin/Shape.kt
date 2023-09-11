abstract class Shape(
    var name: String
) {

    protected val ratio = 3

    init {
        println("Super class of shape")
    }

    abstract fun area(): Double

    abstract fun perimeter(): Double

    fun changeName(newName: String) {
        name = newName
    }

}