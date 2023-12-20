package adventofcode.day03

class DocumentScanner(
    private val document : List<String>
) {

    fun findAllWithValue( lookChar : Char ) : Set<Location> {
        val locationSet = HashSet<Location>()
        for (y in document.indices) {
            val line = document[y]
            for (x in line.indices) {
                val c = line[x]
                if (c == lookChar) {
                    locationSet.add(Location(x, y))
                }
            }
        }
        return locationSet
    }

}