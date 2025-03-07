package arc

class Terminal {
    private val prizeCategories = listOf(
        PrizeCategory("Candy", 10, 5),
        PrizeCategory("Hat", 30, 6),
        PrizeCategory("Glasses", 20, 10)
    )

    fun addCredits(card: Card, dollars: Int) {
        val creditsToAdd = dollars * 2
        card.addCredits(creditsToAdd)
        println("Added $creditsToAdd credits to Card #${card.cardNumber}. Current balance: ${card.credits} credits.")
    }

    fun transferCredits(from: Card, to: Card) {
        if (from.isExpired()) {
            println("Card #${from.cardNumber} is expired and cannot transfer credits.")
            return
        }

        to.addCredits(from.credits)
        from.credits = 0
        println("Transferred all credits from Card #${from.cardNumber} to Card #${to.cardNumber}.")
    }

    fun transferTickets(from: Card, to: Card) {
        if (from.isExpired()) {
            println("Card #${from.cardNumber} is expired and cannot transfer tickets.")
            return
        }

        to.addTickets(from.tickets)
        from.tickets = 0
        println("Transferred all tickets from Card #${from.cardNumber} to Card #${to.cardNumber}.")
    }

    fun requestPrize(prizeName: String, card: Card) {
        if (card.isExpired()) {
            println("Card #${card.cardNumber} is expired and cannot request prizes.")
            return
        }

        val prize = prizeCategories.find { it.name.equals(prizeName, ignoreCase = true) }
        if (prize != null) {
            if (card.tickets >= prize.ticketsRequired && prize.stock > 0) {
                card.tickets -= prize.ticketsRequired
                prize.stock--
                println("Card #${card.cardNumber} claimed a '$prizeName'. Remaining stock: ${prize.stock}.")
            } else if (card.tickets < prize.ticketsRequired) {
                println("Card #${card.cardNumber} does not have enough tickets for '$prizeName'.")
            } else {
                println("Prize '$prizeName' is out of stock.")
            }
        } else {
            println("Prize '$prizeName' does not exist.")
        }
    }

    fun checkBalance(card: Card) {
        if (card.isExpired()) {
            println("Card #${card.cardNumber} is expired. No balance available.")
        } else {
            println("Card #${card.cardNumber}: ${card.credits} credits, ${card.tickets} tickets.")
        }
    }
}
