package adventofcode.day02

import org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

fun main(args: Array<String>) {
    val document = IOUtils.resourceToString("/adventofcode/day02/input.txt", StandardCharsets.UTF_8)

    val gameList = GamesReader.read(document)

    val power = Game.computePower( gameList)

    println("Day 02, exercice 2, result  $power")
}
