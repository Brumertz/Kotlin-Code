// test clock.kt
package test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import Clock

class ClockTest {

    @Test
    fun testDefaultConstructor() {
        // Create a clock instance using the default constructor
        val clock = Clock()

        // Assert the default time is 0:0:0
        assertEquals(0, clock.hour)
        assertEquals(0, clock.minute)
        assertEquals(0, clock.second)
    }

    @Test
    fun testAdvanceSecond() {
        // Create a clock instance with a specific time (23:59:59)
        val clock = Clock(23, 59, 59)

        // Advance the clock by one second
        clock.advOneSecond()

        // Assert that the clock has reset to 0:0:0 after advancing by one second
        assertEquals(0, clock.hour)
        assertEquals(0, clock.minute)
        assertEquals(0, clock.second)
    }

    @Test
    fun testSetValidTime() {
        // Create a clock instance using the default constructor
        val clock = Clock()

        // Set a valid time (10:15:30)
        clock.setTime(10, 15, 30)

        // Assert that the time is correctly set
        assertEquals(10, clock.hour)
        assertEquals(15, clock.minute)
        assertEquals(30, clock.second)
    }

    @Test
    fun testSetInvalidTime() {
        // Create a clock instance with an initial time (12:30:45)
        val clock = Clock(12, 30, 45)

        // Attempt to set an invalid time (25:70:80)
        clock.setTime(25, 70, 80)

        // Assert that the time should remain unchanged
        assertEquals(12, clock.hour)
        assertEquals(30, clock.minute)
        assertEquals(45, clock.second)
    }

    @Test
    fun testResetClock() {
        // Create a clock instance with a specific time (12:30:45)
        val clock = Clock(12, 30, 45)

        // Reset the clock
        clock.reset()

        // Assert that the clock has been reset to 0:0:0
        assertEquals(0, clock.hour)
        assertEquals(0, clock.minute)
        assertEquals(0, clock.second)
    }
}
