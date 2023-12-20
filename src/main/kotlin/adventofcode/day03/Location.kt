package adventofcode.day03

data class Location(val x: Int, val y: Int) {

    fun getNeighbours(): List<Location> {
        val neighbourList = ArrayList<Location>()
        for (neighbourX in x - 1..x + 1) {
            for (neighbourY in y - 1..y + 1) {
                if (!(neighbourX == x && neighbourY == y)) {
                    neighbourList.add(Location(neighbourX, neighbourY))
                }
            }
        }
        return neighbourList
    }

}
