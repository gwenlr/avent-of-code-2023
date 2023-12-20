package adventofcode.day03

class SymbolCollection(
    document: List<String>
) {
    private val symbolLocationSet = HashSet<Location>()

    init {
        for (y in document.indices) {
            val line = document[y]
            for (x in line.indices) {
                val c = line[x]
                if (c != '.' && !c.isDigit()) {
                    symbolLocationSet.add(Location(x, y))
                }
            }
        }
    }

    fun isSymbolAt(location: Location): Boolean {
        return symbolLocationSet.contains(location)
    }

    fun isSymbolAroundOf(location: Location): Boolean {
        for (x in location.x - 1..location.x + 1) {
            for (y in location.y - 1..location.y + 1) {
                val currentLocation = Location(x, y)
                if (currentLocation != location) {
                    if (symbolLocationSet.contains(currentLocation))
                        return true
                }
            }
        }
        return false
    }

}