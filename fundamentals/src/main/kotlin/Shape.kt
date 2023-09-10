open class Shape(
    var name: String
) {

    init {
        println("Super class of shape")
    }

    fun changeName(newName: String) {
        name = newName
    }

}