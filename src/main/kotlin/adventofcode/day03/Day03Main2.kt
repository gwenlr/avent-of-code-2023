package adventofcode.day03

import adventofcode.utils.DocumentReader

fun main(args: Array<String>) {
    val document = DocumentReader.readFromResource("/adventofcode/day03/input.txt")
    println("Document")
    println("<<<")
    document.forEach(::println)
    println(">>>")


    val schematicAnalyzer = EngineSchematicAnalyzer(document)
    val notPartNumbers = schematicAnalyzer.getPartNumbers()
    val notPartNumbersSum = notPartNumbers.sum()
    println("Day 03, exercice 1, result  $notPartNumbersSum")
}