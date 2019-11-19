package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var correctPosition = 0
    var incorrectPosition = 0
    var secretCopy = secret
    var guessCopy = guess

    for (i in guess.indices) {
        if (guess[i] == secret[i]) {
            correctPosition++
            secretCopy = secretCopy.replaceFirst(guess[i].toString(), "")
            guessCopy = guessCopy.replaceFirst(guess[i].toString(), "")
        }
    }
    for (i in guessCopy.indices) {
        if (secretCopy.contains(guessCopy[i])) {
            incorrectPosition++
            secretCopy = secretCopy.replaceFirst(guess[i].toString(), "")

        }
    }
    var eval = Evaluation(correctPosition, incorrectPosition)
    return eval
}


fun evaluateGuessFunctionalSolution(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { it.first == it.second }

    val commonLetters = "ABCDEF".sumBy { ch ->

        Math.min(secret.count { it==ch }, guess.count { it==ch })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}
