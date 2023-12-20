package adventofcode.day03

class GearComputer(
) {

    fun doCompute(document: List<String>) {
        var number = -1
        val starLocations = HashSet<Location>()
        for (y in document.indices) {
            val line = document[y]
            for (x in line.indices) {
                val c = line[x]
                if (c.isDigit()) {
                    if (number == -1)
                        number = c.digitToInt()
                    else
                        number = number*10+c.digitToInt()

                } else {
                    if( number != -1) {

                    }
                }
            }
        }
    }

    private fun checkStar(starLocation: Location) {
        //val left = starLocation.
    }
}