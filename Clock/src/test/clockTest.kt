package test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import Clock
import ClockData  // Ensure you import ClockData

class ClockTest {

    @Test
    fun testDefaultConstructor() {
        val clockData = ClockData()  // Create ClockData instance
        val clock = Clock(clockData)

        assertEquals(0, clockData.hour)
        assertEquals(0, clockData.minute)
        assertEquals(0, clockData.second)
    }

    @Test
    fun testAdvanceSecond() {
        val clockData = ClockData(23, 59, 59)
        val clock = Clock(clockData)
        clock.advance()

        assertEquals(0, clockData.hour)
        assertEquals(0, clockData.minute)
        assertEquals(0, clockData.second)
    }

    @Test
    fun testSetValidTime() {
        val clockData = ClockData()
        val clock = Clock(clockData)
        clock.setTime(10, 15, 30)

        assertEquals(10, clockData.hour)
        assertEquals(15, clockData.minute)
        assertEquals(30, clockData.second)
    }

    @Test
    fun testSetInvalidTime() {
        val clockData = ClockData(12, 30, 45)
        val clock = Clock(clockData)
        clock.setTime(25, 70, 80)  // Invalid input

        // The time should not change
        assertEquals(12, clockData.hour)
        assertEquals(30, clockData.minute)
        assertEquals(45, clockData.second)
    }

    @Test
    fun testResetClock() {
        val clockData = ClockData(12, 30, 45)
        val clock = Clock(clockData)
        clock.reset()

        assertEquals(0, clockData.hour)
        assertEquals(0, clockData.minute)
        assertEquals(0, clockData.second)
    }
}
