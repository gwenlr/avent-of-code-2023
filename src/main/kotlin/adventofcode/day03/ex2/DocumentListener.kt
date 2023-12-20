package adventofcode.day03.ex2

import adventofcode.day03.Location

interface DocumentListener {
    fun startParsingDocument()

    fun endParsingDocument()

    fun startParsingLine()

    fun endParsingLine()

    fun parsingDigit(location: Location, digit: Char)

    fun parsingNumber(number: Int)

    fun parsingSymbol(location: Location, symbol: Char)
}