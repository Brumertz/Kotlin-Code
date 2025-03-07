package arc

import java.time.LocalDate
import java.time.temporal.ChronoUnit

class Card {
    var credits = 0
    var tickets = 0
    val cardNumber: Int
    val issueDate: LocalDate
    var expiryDate: LocalDate

    init {
        cardNumber = generateUniCardNum()
        issueDate = LocalDate.now()
        expiryDate = issueDate.plus(1, ChronoUnit.YEARS) // Card expires after 1 year
    }

    companion object {
        private var nextCardNumber = 1

        fun generateUniCardNum(): Int {
            return nextCardNumber++
        }
    }

    fun addCredits(amount: Int) {
        credits += amount
    }

    fun addTickets(amount: Int) {
        tickets += amount
    }

    fun deductCredits(amount: Int): Boolean {
        return if (credits >= amount) {
            credits -= amount
            true
        } else {
            println("Card #$cardNumber has insufficient credits.")
            false
        }
    }

    fun isExpired(): Boolean {
        return LocalDate.now().isAfter(expiryDate)
    }
}
