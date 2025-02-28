

class Clock(private val  clockData: ClockData) {

    // Resets the time to 0:0:0
    fun reset() {
        clockData.hour = 0
        clockData.minute = 0
        clockData.second = 0
    }

    // Advances time by one second
    fun advance() {
        clockData.second++
        if (clockData.second == 60) {
            clockData.second = 0
            clockData.minute++
            if (clockData.minute == 60) {
                clockData.minute = 0
                clockData.hour++
                if (clockData.hour == 24) {
                    clockData.hour = 0
                }
            }
        }
    }

    // Updates the time if valid input is provided
    fun setTime(hour: Int, minute: Int, second: Int) {
        if (hour in 0..23 && minute in 0..59 && second in 0..59) {
            clockData.hour = hour
            clockData.minute = minute
            clockData.second = second
        } else {
            println("Invalid time input. Keeping previous time.")
        }
    }

    // Displays the current time
    fun displayTime() {
        println("The current time ==> ${clockData.hour} : ${clockData.minute} : ${clockData.second}")
    }
}