# `var`, `val`

- `var` can be reassigned
- `val` cannot be reassigned

```

val name = "Docker"
val age = 13

println("the value of name is: $name and age: $age")

```

---

# Decimal Numbers

- `Float` uses less memory compared to `Double`
- The precision of Float is only six or seven decimal digits, while Double variables have a precision of about 15 digits

---

# Array and list

to create array and list

```

val myArray = arrayOf(1, 2, 3)
val myList = listof(1, 2, 3)
val myMutableList = mutableListOf(1, 2, 3)

myArray[0] = 3 // can change during runtime
myList[0] = 3 // cannot be changed during runtime
myMutableList[0] = 3 // can change during runtime

```

---


# `when` keyword

- Essentially the switch case of kotlin


---

# Visibility Modifiers

- private: only visible to the inside of the class
- protected: can pass down to sub-classes that inherit from super-class


---

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