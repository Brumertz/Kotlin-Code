package arc

import kotlin.random.Random

class Game(private val costPerPlay: Int) {
    fun play(card: Card) {
        if (card.isExpired()) {
            println("Card #${card.cardNumber} is expired and cannot play.")
            return
        }

        if (card.deductCredits(costPerPlay)) {
            val ticketsWon = Random.nextInt(1, 11)
            card.addTickets(ticketsWon)
            println("Card #${card.cardNumber} played and won $ticketsWon tickets!")
        }
    }
}
