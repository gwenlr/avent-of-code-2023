package adventofcode.day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Calibration2Test {

    @Test
    fun `calibrate shall calibrate`() {
        assertThat(
            Calibration2.calibrate(
                """
                42
            """.trimIndent()
            )
        ).isEqualTo(42)
    }

    @Test
    fun `calibrate shall calibrate one line`() {
        assertThat(
            Calibration2.calibrate(
                """
                two1nine
            """.trimIndent()
            )
        ).isEqualTo(29)
    }

    @Test
    fun calibrate() {
        assertThat(
            Calibration2.calibrate(
                """
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen
            """.trimIndent()
            )
        ).isEqualTo(281)
    }

    @Test
    fun `calibrate each textual number`() {
        assertThat(
            Calibration2.calibrate("onetwo")
        ).isEqualTo(12)

        assertThat(
            Calibration2.calibrate("threefour")
        ).isEqualTo(34)

        assertThat(
            Calibration2.calibrate("fivesix")
        ).isEqualTo(56)

        assertThat(
            Calibration2.calibrate("seveneight")
        ).isEqualTo(78)

        assertThat(Calibration2.calibrate("nine"))
            .isEqualTo(99)
    }
}