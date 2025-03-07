package arc

fun main() {
    val card1 = Card() // Unique ID 1
    val card2 = Card() // Unique ID 2

    val game1 = Game(5)
    val game2 = Game(7)

    val terminal = Terminal()

    terminal.addCredits(card1, 20)  // 40 credits
    terminal.addCredits(card2, 20)  // 40 credits

    println("\n>>> Card #1 plays Game #1 five times")
    repeat(5) { game1.play(card1) }

    println("\n>>> Card #2 plays Game #2 five times")
    repeat(5) { game2.play(card2) }

    println("\n>>> Transfer credits & tickets from Card #1 to Card #2")
    terminal.transferCredits(card1, card2)
    terminal.transferTickets(card1, card2)

    println("\n>>> Request prizes using Card #2")
    terminal.requestPrize("Candy", card2)
    terminal.requestPrize("Hat", card2)

    println("\n>>> Try playing a game with Card #1")
    game1.play(card1)

    println("\n>>> Final balance check for both cards")
    terminal.checkBalance(card1)
    terminal.checkBalance(card2)
}
