package adventofcode.day02

import java.util.regex.Pattern

object GamesReader {

    fun read(document: String): List<Game> {
        return splitToLines(document)
            .map(::toGameRecord)
    }

    private fun splitToLines(text: String): List<String> {
        return text.split(Pattern.compile("\\r?\\n"))
    }


    private fun toGameRecord(gameStatement: String): Game {
        //Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        val splitInstruction = gameStatement.split(":")
        if (splitInstruction.size != 2)
            throw IllegalArgumentException("Invalid line: $gameStatement")

        val gameId = extractGameId(splitInstruction[0])
        val rolls = splitInstruction[1].split(";").map(::toRoll2).toSet()
        return Game(gameId, rolls)
    }

    private fun extractGameId(header: String): Int {
        return header.substring("Game ".length).toInt()
    }


    private fun toRoll2(rollStatement: String): Roll {
        var blue = 0
        var green = 0
        var red = 0
        rollStatement.split(",")
            .forEach{
                val fields = it.trim().split(" ")
                val count = fields[0].toInt()
                when (fields[1]) {
                    "blue" -> blue+=count
                    "green" -> green+=count
                    "red" -> red+=count
                }
            }
        return Roll(blue, green, red)
    }
}