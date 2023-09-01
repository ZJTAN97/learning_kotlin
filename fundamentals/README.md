# Data classes

- main purpose is to hold data
- Comes automatically with additional member functions that allow you to print an instance to readable output, compare instances and more.
- enables us to avoid writing getters, setters, equals, and hashCode methods

```
data class User(val name: String, val age: Int)

val user = User("Kotlin", "10")

println(user.age) // returns 10
println(user.name) // returns "Kotlin"

// Can destructure also
val(name, age) = user

```

- To ensure consistency and meaningful behavior of generated code, data classes need to fufill
  - The primary constructor needs to have at least one parameter
  - All primary constructor parameters need to be marked with as `val` or `var`
  - Data classes cannot be abstract, open, sealed or inner