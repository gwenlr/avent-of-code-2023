package adventofcode.day02

import kotlin.math.max

data class Game(
    val id: Int,
    val rolls: Set<Roll>
) {

    fun isCompatibleWith(bag: Roll): Boolean {
        return rolls.all{
            bag.blue >= it.blue && bag.green >= it.green && bag.red >= it.red
        }
    }

    fun power() : Int {
        var maxBlue = 0
        var maxGreen = 0
        var maxRed = 0
        rolls.forEach{
            maxBlue = max( maxBlue, it.blue)
            maxGreen = max( maxGreen, it.green)
            maxRed = max( maxRed, it.red)
        }
        return maxBlue*maxGreen*maxRed
    }

    companion object {
        fun findCompatibleGameIds(bag : Roll, games: Collection<Game>) : Set<Int> {
            return games.filter { it.isCompatibleWith(bag) }.map { it.id }.toSet()
        }

        fun computePower(games: Collection<Game> ): Int {
            return games.map(Game::power).sum()
        }
    }
}