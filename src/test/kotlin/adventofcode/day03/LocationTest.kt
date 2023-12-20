package adventofcode.day03

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LocationTest {

    @Test
    fun `getNeighbours 4 5`() {
        assertThat( Location(4,5).getNeighbours())
            .hasSize(8)
            .containsOnly(
                Location(3,4),
                Location(4,4),
                Location(5,4),
                Location(3,5),
                Location(5,5),
                Location(3,6),
                Location(4,6),
                Location(5,6),
            )
    }

    @Test
    fun `getNeighbours 3 2`() {
        assertThat( Location(3,2).getNeighbours())
            .hasSize(8)
            .containsOnly(
                Location(2,1),
                Location(3,1),
                Location(4,1),
                Location(2,2),
                Location(4,2),
                Location(2,3),
                Location(3,3),
                Location(4,3),
            )
    }
}