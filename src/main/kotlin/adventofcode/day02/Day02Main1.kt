package adventofcode.day02

import org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

fun main(args: Array<String>) {
    val document = IOUtils.resourceToString("/adventofcode/day02/input.txt", StandardCharsets.UTF_8)

    val gameList = GamesReader.read(document)

    val bag = Roll(red=12, green = 13, blue = 14)

    val gameIdSum = Game.findCompatibleGameIds(bag, gameList).sum()

    println("Day 02, exercice 1, result  $gameIdSum")
}
