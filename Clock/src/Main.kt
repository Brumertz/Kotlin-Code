fun main() {
    val clock = Clock()  // Default clock (0:0:0)

    println("Welcome to the Simple Clock Program")

    while (true) {
        clock.displayTime()

        println("Enter 's' to set the time.")
        println("Enter 'a' to advance one second.")
        println("Enter 'r' to reset the clock.")
        println("Enter 'q' to quit.")
        print("Your choice: ")

        when (readlnOrNull()?.lowercase()) {
            "s" -> {
                println("Now you can set the clock")

                // Get valid inputs from the user for hour, minute, and second.
                val hour = getIntInput("Enter hour (0 ~ 23): ", 0..23)
                val minute = getIntInput("Enter minute (0 ~ 59): ", 0..59)
                val second = getIntInput("Enter second (0 ~ 59): ", 0..59)

                // Set the time using the Clock class method.
                clock.setTime(hour, minute, second)
            }

            "a" -> {
                // Advance the clock by one second
                clock.advOneSecond()  // Corrected method name to match the class definition
            }

            "r" -> {
                // Reset the clock
                clock.reset()
                println("The clock has been reset.")
            }

            "q" -> {
                // Exit the program
                println("Exiting program. Goodbye!")
                return
            }

            else -> println("Invalid option. Please try again.")
        }
    }
}

// Function to get integer input within a specified range
fun getIntInput(prompt: String, range: IntRange): Int {
    while (true) {
        print(prompt)
        val input = readlnOrNull()?.toIntOrNull() // Convert input to Int?

        if (input != null && input in range) { // Now input is an Int
            return input
        } else {
            println("Invalid input. Please enter a number between ${range.first} and ${range.last}.")
        }
    }
}
