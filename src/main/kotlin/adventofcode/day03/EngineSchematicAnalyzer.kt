package adventofcode.day03

class EngineSchematicAnalyzer(
    private val schemaLineList: List<String>
) : SymbolAnalyzer {
    init {
        if (schemaLineList.isEmpty() || schemaLineList[0].isEmpty())
            throw IllegalArgumentException("Invalid schema")
    }

    private val maxY = schemaLineList.size - 1
    private val maxX = schemaLineList[0].length - 1

    override fun hasSymbolAround(x: Int, y: Int): Boolean {
        return hasSymbolAround(Location(x, y), ::isSymbol)
    }

    private fun hasSymbolAround(location: Location, matcher: (c: Char) -> Boolean) : Boolean {
        return location.getNeighbours().any {
            isSymbolAt(it, matcher)
        }
    }

    fun isSymbolAt(location: Location, matcher: (c: Char) -> Boolean): Boolean {
        if (isOnSchema(location)) {
            val c = charAt(location)
            return matcher(c)
        }
        return false
    }

    private fun isOnSchema(location: Location): Boolean {
        return location.x in 0..maxX
                && 0 <= location.y && location.y <= maxY
    }


    private fun charAt(location: Location): Char {
        return schemaLineList[location.y][location.x]
    }

    fun getPartNumbers(): List<Int> {
        val allPartNumbers = ArrayList<Int>()
        val lineParser = LineParser(this)

        for ((lineId, line) in schemaLineList.withIndex()) {
            val linePartNumbers = lineParser.getPartNumbers(line, lineId)
            allPartNumbers.addAll(linePartNumbers)
        }

        return allPartNumbers
    }

    override fun hasStarAround(x: Int, y: Int): Boolean {
        return hasSymbolAround(Location(x, y), ::isStar)
    }

    companion object {
        private fun isSymbol(char : Char ): Boolean {
            return char != '.' && !char.isDigit()
        }

        private fun isStar(char : Char ): Boolean {
            return char == '*'
        }

    }
}