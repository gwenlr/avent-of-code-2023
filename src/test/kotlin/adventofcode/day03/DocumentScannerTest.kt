package adventofcode.day03

import adventofcode.utils.DocumentReader
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DocumentScannerTest {

    @Test
    fun findAllWithValue() {
        val document = DocumentReader.read(EngineSchematicAnalyzerTest.SCHEMA)
        val scanner = DocumentScanner(document)
        val starLocations = scanner.findAllWithValue('*')

        assertThat(starLocations)
            .containsOnly(
                Location(3,1),
                Location(3,4),
                Location(5,8)
            )
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