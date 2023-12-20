package adventofcode.day03

interface SymbolAnalyzer {
    fun hasSymbolAround(x: Int, y: Int): Boolean
    fun hasStarAround(x: Int, y: Int): Boolean
}