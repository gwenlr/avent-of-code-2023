package adventofcode.day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GamesReaderTest {

    @Test
    fun `Shall read single game`() {
        val gameList = GamesReader.read(
            """
                    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                """.trimIndent()
        )

        assertThat(
            gameList
        ).hasSize(1)
            .extracting("id")
            .containsExactly(1)

        assertThat(gameList[0].rolls)
            .containsExactly(
                Roll(blue=3, red=4),
                Roll(red=1, green = 2, blue = 6),
                Roll(green = 2),
            )
    }


    @Test
    fun `shall read all lines`() {
        val gameList = GamesReader.read(
            """
                    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                    Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                    Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                    Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                    Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                """.trimIndent()
        )
        assertThat(
            gameList
        ).hasSize(5)
            .containsExactly(
                // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game(1, setOf( Roll(blue=3, red=4), Roll(red=1, green = 2, blue = 6), Roll(green = 2))),
                // Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game(2, setOf( Roll(blue=1, green = 2), Roll(green = 3, blue=4, red = 1), Roll(green = 1, blue = 1))),
                // Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game(3, setOf( Roll(green = 8, blue=6, red = 20), Roll(blue=5, red=4, green = 13), Roll(green = 5, red = 1))),
                // Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game(4, setOf( Roll(green = 1, red = 3, blue = 6), Roll(green = 3, red = 6), Roll(green = 3, blue = 15, red = 14))),
                //Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                Game(5, setOf( Roll(red = 6, blue=1, green = 3), Roll(blue = 2, red = 1, green = 2)))
            )
    }


    @Test
    fun `isCompatibleWith single game`() {
        val game = GamesReader.read(
            """
                    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                """.trimIndent()
        ).first()

        assertThat( game.isCompatibleWith(Roll(blue = 1, red = 1, green = 1)))
            .isFalse()

        assertThat( game.isCompatibleWith(Roll(blue = 3, red = 2, green = 1)))
            .isFalse()

        assertThat( game.isCompatibleWith(Roll(blue = 6, red = 4, green = 2)))
            .isTrue()

        assertThat( game.isCompatibleWith(Roll(blue = 7, red = 4, green = 2)))
            .isTrue()

        assertThat( game.isCompatibleWith(Roll(blue = 6, red = 7, green = 2)))
            .isTrue()
    }

    @Test
    fun `isCompatibleWith several games`() {
        val gameList = GamesReader.read(
            """
                    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                    Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                    Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                    Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                    Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
            """.trimIndent()
        )

        val bag = Roll(red=12, green = 13, blue = 14)

        assertThat( gameList[0].isCompatibleWith(bag))
            .isTrue()
        assertThat( gameList[1].isCompatibleWith(bag))
            .isTrue()
        assertThat( gameList[2].isCompatibleWith(bag))
            .isFalse()
        assertThat( gameList[3].isCompatibleWith(bag))
            .isFalse()
        assertThat( gameList[4].isCompatibleWith(bag))
            .isTrue()
    }


    @Test
    fun `findCompatibleGames empty list`() {
        val bag = Roll(red=12, green = 13, blue = 14)

        assertThat(Game.findCompatibleGameIds(bag, emptyList()))
            .isEmpty()
    }

    @Test
    fun `findCompatibleGames filled list`() {
        val bag = Roll(red=12, green = 13, blue = 14)

        val gameList = GamesReader.read(
            """
                    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                    Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                    Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                    Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                    Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
            """.trimIndent()
        )

        assertThat(Game.findCompatibleGameIds(bag, gameList))
            .isEqualTo(setOf(1,2,5))
    }


    @Test
    fun `power single game`() {
        val gameList = GamesReader.read(
            """
                    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                    Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                    Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                    Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                    Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
            """.trimIndent()
        )

        assertThat(gameList[0].power())
            .isEqualTo(48)

        assertThat(gameList[1].power())
            .isEqualTo(12)

        assertThat(gameList[2].power())
            .isEqualTo(1560)

        assertThat(gameList[3].power())
            .isEqualTo(630)

        assertThat(gameList[4].power())
            .isEqualTo(36)
    }

    @Test
    fun `computePower single game`() {
        val gameList = GamesReader.read(
            """
                    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                    Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                    Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                    Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                    Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
            """.trimIndent()
        )

        assertThat(Game.computePower(gameList.subList(0,1)))
            .isEqualTo(48)
    }

    @Test
    fun `computePower several games`() {
        val gameList = GamesReader.read(
            """
                    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                    Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                    Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                    Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                    Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
            """.trimIndent()
        )

        assertThat(Game.computePower(gameList))
            .isEqualTo(2286)
    }
}