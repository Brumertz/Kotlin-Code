// The Clock class
class Clock(hour: Int = 0, minute: Int = 0, second: Int = 0) {

    // Properties that represent the current time of the clock.
    var hour: Int
    var minute: Int
    var second: Int

    // Primary constructor
    init {

        this.hour = if (hour in 0..23) hour else 0
        this.minute = if (minute in 0..59) minute else 0
        this.second = if (second in 0..59) second else 0
    }

    // Secondary constructor.

    constructor(hour: Int, minute: Int, second: Int, validate: Boolean) : this(hour, minute, second) {
        // If validation is enabled and the provided time values are invalid, reset the time to 0:0:0.
        if (validate && !(hour in 0..23 && minute in 0..59 && second in 0..59)) {
            println("Invalid time. Resetting to 0:0:0")
            reset() // Reset the time to 0:0:0 if validation fails.
        }
    }

    // Resets the time to 0:0:0.
    fun reset() {
        hour = 0
        minute = 0
        second = 0
    }

    fun advOneSecond() {
        second++ // Increment second by 1.
        if (second == 60) { // If seconds reach 60, reset seconds to 0 and increment the minute.
            second = 0
            minute++ // Increment minute by 1.
            if (minute == 60) { // If minutes reach 60, reset minutes to 0 and increment the hour.
                minute = 0
                hour++ // Increment hour by 1.
                if (hour == 24) { // If hours reach 24, reset to 0 (24-hour format).
                    hour = 0
                }
            }
        }
    }

    // Sets the time with validation.

    fun setTime(newHour: Int, newMinute: Int, newSecond: Int) {
        if (newHour in 0..23 && newMinute in 0..59 && newSecond in 0..59) {
            hour = newHour
            minute = newMinute
            second = newSecond
        } else {
            println("Invalid time input!")
        }
    }

    // Displays the current time in the format HH:MM:SS (with leading zeros if necessary).
    fun displayTime() {
        // Uses a formatted string to display the time with leading zeros if needed.
        println("The current time ==> %02d:%02d:%02d".format(hour, minute, second))
    }
}
