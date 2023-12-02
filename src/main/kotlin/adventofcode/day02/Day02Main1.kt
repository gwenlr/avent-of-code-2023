package adventofcode.day02

import org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

fun main(args: Array<String>) {
    val document = IOUtils.resourceToString("/adventofcode/day02/input.txt", StandardCharsets.UTF_8)

    val gameList = GamesReader.read(document)
    // 12 red cubes, 13 green cubes, and 14 blue
    val bag = Roll(red=12, green = 13, blue = 14)

    //val gameIds = Game.findCompatibleGames(bag, gameList)
    val gameIdSum = Game.findCompatibleGameIds(bag, gameList).sum()

    println("Day 02, exercice 1, result  $gameIdSum")
}
