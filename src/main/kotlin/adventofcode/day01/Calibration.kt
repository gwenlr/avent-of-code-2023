package adventofcode.day01

import java.util.regex.Pattern

object Calibration {
    fun calibrate(document: String): Int {
        return splitToLines(document)
            .map(Calibration::extractDigits)
            .sumOf { it.first() * 10 + it.last() }
    }

    private fun splitToLines(text: String): List<String> {
        return text.split(Pattern.compile("\\r?\\n"))
    }

    private fun extractDigits(line: String): List<Int> {
        return line.filter(Char::isDigit).map(Char::digitToInt)
    }

}