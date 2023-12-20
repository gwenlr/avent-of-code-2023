package adventofcode.day03

class GearLineParser(
    private val symbolAnalyzer: SymbolAnalyzer
) {
    private var isPartNumber = false
    private var parsedNumber: Int = 0
    private var partNumberList = ArrayList<Int>()

    fun getPartNumbers(line: String, lineId: Int): List<Int> {
        resetState()
        var columnId = 0
        for (c in line) {
            if (c.isDigit()) {
                isPartNumber = isPartNumber || symbolAnalyzer.hasStarAround(columnId, lineId)
                updateParsedNumber(c)
            } else if (isEndOfNumber()) {
                endParsingNumber()
            }
            columnId++
        }
        if (isEndOfNumber()) {
            endParsingNumber()
        }
        return partNumberList
    }

    private fun resetState() {
        isPartNumber = false
        parsedNumber=0
        partNumberList = ArrayList()
    }

    private fun updateParsedNumber(c: Char) {
        val charValue = c.digitToInt()
        parsedNumber = parsedNumber * 10 + charValue
    }

    private fun isEndOfNumber(): Boolean {
        return parsedNumber != 0
    }

    private fun endParsingNumber() {
        if (isPartNumber) {
            partNumberList.add(parsedNumber)
        }

        isPartNumber=false
        parsedNumber=0
    }
}