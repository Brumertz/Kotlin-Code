fun main() {
    val clockData = ClockData()
    val clock = Clock(clockData)
    var running = true

    while (running) {
        clock.displayTime()
        println("Enter 's' to set the time.")
        println("Enter 'a' to advance one second.")
        println("Enter 'r' to reset the clock.")
        println("Enter 'q' to quit.")

        when (readln().lowercase()) {
            "s" -> {
                println("Now you can set the clock")
                print("Enter hour (0 ~ 23): ")
                val h = readln().toIntOrNull() ?: 0
                print("Enter minute (0 ~ 59): ")
                val m = readln().toIntOrNull() ?: 0
                print("Enter second (0 ~ 59): ")
                val s = readln().toIntOrNull() ?: 0

                clock.setTime(h, m, s)
            }
            "a" -> clock.advance()
            "r" -> clock.reset()
            "q" -> {
                running = false
                println("Goodbye!")
            }
            else -> println("Invalid input. Try again.")
        }
    }
}
