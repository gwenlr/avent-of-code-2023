package adventofcode.day03

import adventofcode.utils.DocumentReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SymbolCollectionTest {

    @Test
    fun isSymbolAt() {
        val document = DocumentReader.read(EngineSchematicAnalyzerTest.SCHEMA)
        val symbolCollection = SymbolCollection(document)

        assertThat( symbolCollection.isSymbolAt(Location(0,0)))
            .isFalse()

        assertThat( symbolCollection.isSymbolAt(Location(3,1)))
            .isTrue()
    }

    @Test
    fun isSymbolAroundOf() {
        val document = DocumentReader.read(EngineSchematicAnalyzerTest.SCHEMA)
        val symbolCollection = SymbolCollection(document)

        assertThat( symbolCollection.isSymbolAroundOf(Location(0,0)))
            .isFalse()

        assertThat( symbolCollection.isSymbolAroundOf(Location(2,0)))
            .isTrue()

        assertThat( symbolCollection.isSymbolAroundOf(Location(2,2)))
            .isTrue()
    }


    companion object {
        val SCHEMA = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...${'$'}.*....
            .664.598..
        """.trimIndent()
    }
}