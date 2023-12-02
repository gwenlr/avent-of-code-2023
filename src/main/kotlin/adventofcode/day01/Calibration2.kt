package adventofcode.day01

import java.util.regex.Pattern

object Calibration2 {
    fun calibrate(document: String): Int {
        return splitToLines(document)
            .map(::extractDigits)
            .sumOf { it.first() * 10 + it.last() }
    }

    private fun splitToLines(text: String): List<String> {
        return text.split(Pattern.compile("\\r?\\n"))
    }

    private fun extractDigits(line: String): List<Int> {
        return line.indices.mapNotNull { toDigit(it, line) }
    }

    private fun toDigit(index: Int, line: String): Int? {
        val firstChar = line[index]
        return if (firstChar.isDigit())
            firstChar.digitToInt()
        else
            findStartingDigitText(line.substring(index))
    }

    private fun findStartingDigitText(text: String): Int? {
        for (entry in DIGIT_TEXT_LIST) {
            if (text.startsWith(entry.first))
                return entry.second
        }
        return null
    }


    private val DIGIT_TEXT_LIST: List<Pair<String, Int>> =
        listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
            .mapIndexed { index, value -> Pair(value, index + 1) }

}