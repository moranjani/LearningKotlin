package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var correctPosition = 0
    var incorrectPosition = 0
    for (i in guess.indices) {
        if (guess[i] == secret[i]) {
            correctPosition++;
        } else {
            if (secret.contains(guess[i])) {
                incorrectPosition++
            }
        }
    }
    var eval = Evaluation(correctPosition, incorrectPosition)
    return eval
}
