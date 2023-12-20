package adventofcode.day03

import adventofcode.utils.DocumentReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EngineSchematicAnalyzerTest {

    @Test
    fun isSymbolAt() {
        val document = DocumentReader.read(SCHEMA)
        val analyser = EngineSchematicAnalyzer(document)

        assertThat(analyser.isSymbolAt(Location(0, 0)))
            .isFalse()

        assertThat(analyser.isSymbolAt(Location(0, 1)))
            .isFalse()

        assertThat(analyser.isSymbolAt(Location(1, 1)))
            .isFalse()

        assertThat(analyser.isSymbolAt(Location(3, 1)))
            .isTrue()
    }

    @Test
    fun hasSymbolAround() {
        val document = DocumentReader.read(SCHEMA)
        val analyser = EngineSchematicAnalyzer(document)

        assertThat(analyser.hasSymbolAround(0, 0))
            .isFalse()

        assertThat(analyser.hasSymbolAround(2, 0))
            .isTrue()

        assertThat(analyser.hasSymbolAround(2, 2))
            .isTrue()

        assertThat(analyser.hasSymbolAround(3, 2))
            .isTrue()

        assertThat(analyser.hasSymbolAround(7, 5))
            .isFalse()

        assertThat(analyser.hasSymbolAround(8, 5))
            .isFalse()
    }


    @Test
    fun getNotPartNumbers() {
        val document = DocumentReader.read(SCHEMA)
        val analyser = EngineSchematicAnalyzer(document)
        val partNumbers = analyser.getPartNumbers()

        assertThat(partNumbers)
            .doesNotContain(114, 58)

        assertThat(partNumbers.sum())
            .isEqualTo(4361)
    }

    @Test
    fun getNotPartNumbers2() {
        val document = DocumentReader.read(SCHEMA_2)
        val analyser = EngineSchematicAnalyzer(document)
        val partNumbers = analyser.getPartNumbers()

        assertThat(partNumbers)
            .doesNotContain(770, 512, 983, 140, 445, 709)
    }


    @Test
    fun hasSymbolAround2() {
        val document = DocumentReader.read(
            """
            467..114..
            ...*......
            ..35...633            
        """.trimIndent()
        )
        val analyser = EngineSchematicAnalyzer(document)

        val partNumbers = analyser.getPartNumbers()

        assertThat(partNumbers)
            .doesNotContain(114, 633)

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

    val SCHEMA_2 = """
        ......124..................418.......587......770...........672.................564............................438..........512......653....
        665/...*......................*599.....*.983......794*..140..*...........@..963*....................445........*......*.........709.....*...
    """.trimIndent()
}