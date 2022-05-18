import java.util.*
import kotlin.random.Random

val words = listOf("bed", "house", "panda", "basketball", "soccer", "summer", "church", "mustang", "brazil", "motocycle", "bird", "country", "justice", "scarecrow", "batman", "avengers", "development", "javascript", "golang", "island", "pirate", "ship", "waves", "tornado")
var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main(args: Array<String>) {
    setupGame()
}

fun setupGame() {
    val wordIndex = Random.nextInt(words.size);
    word = words[wordIndex].uppercase()

    for(i in word.indices) guesses.add('_')
    var gameOver = false

    do {
        gameStatus()
        println("Please, enter a letter: ")
        val input = readLine() ?: ""

        if(input.isEmpty()) {
            println("That's not a valid input. Please try again")
        } else {
            val letter: Char = input[0]
            if(word.contains(letter)) {
                for(i in word.indices) if(word[i].equals(letter)) guesses[i] = letter
                if(!guesses.contains('_')) {
                    gameOver = true
                    println("You won! Congratulations! The word was $word.")
                }
            } else {
                println("Sorry, that's not part of the word!")
                remainingGuesses--
                mistakes++
                if(mistakes == 6) {
                    gameStatus()
                    gameOver = true
                    println("Game over! The word was $word.")
                }
            }
        }
    } while(!gameOver)


}

fun gameStatus() {
    when(mistakes) {
        0 -> image()
        1 -> image(" O ")
        2 -> image(" O ", " | ")
        3 -> image(" O ", "/| ")
        4 -> image(" O ", "/|\\")
        5 -> image(" O ", "/|\\", "/")
        6 -> image(" O ", "/|\\", "/ \\")
    }

    print("Word: ")
    for(element in guesses) print("$element ")
    println("\nYou have ${6 - mistakes} guess(es) left!")
}

fun manImage(head: String, body: String, legs: String) {
    println("  |    $head")
    println("  |    $body")
    println("  |    $legs")
}

fun image(head: String = "   ",
          body: String = "   ",
          legs: String = "   ") {
    println("  |-----|--")
    println("  |     |  ")
    manImage(head, body, legs)
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}