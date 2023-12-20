package adventofcode.day03.ex2

import adventofcode.day03.Location

class DocumentParser2(
//    private val symbolAnalyzer: SymbolAnalyzer
) {

    private val listeners = ArrayList<DocumentListener>()
    private var isPartNumber = false
    private var parsedNumber: Int = 0
    private var partNumberList = ArrayList<Int>()

    fun addListener( listener : DocumentListener) {
        if( !listeners.contains(listener))
            listeners.add(listener)
    }

    fun parse(    document : List<String>    ) {
        for (y in document.indices) {
            val line = document[y]
            startParsingLine(y)
            for (x in line.indices) {
                val c = line[x]
                parse( Location(x,y), c)
            }
            endParsingLine(y)
        }
    }

    private fun parse( location : Location , c : Char) {

    }

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