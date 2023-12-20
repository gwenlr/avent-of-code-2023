package adventofcode.day03

class StarRegistry {

    private val starMap = HashMap<Location, MutableSet<Int>>()

    fun addNumberLinkedToStar(number: Int, starLocation: Location) {
        if (!starMap.containsKey(starLocation))
            starMap[starLocation] = HashSet()

        starMap[starLocation]!!.add(number)
    }

    fun getAllGears() : Set<Pair<Int,Int>> {
        return  starMap.filter { it.value.size==2 }
            .map { it.value.toList() }
            .map { Pair(it[0], it[1]) }
            .toSet()
    }
}