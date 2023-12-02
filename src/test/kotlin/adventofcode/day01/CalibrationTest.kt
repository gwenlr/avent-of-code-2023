package adventofcode.day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalibrationTest {

    @Test
    fun `calibrate shall handle single line with single value`() {
        assertThat(Calibration.calibrate("1ab"))
            .isEqualTo(11)
    }

    @Test
    fun `calibrate shall handle single line with two values`() {
        assertThat(Calibration.calibrate("1abc2"))
            .isEqualTo(12)
    }

    @Test
    fun `calibrate shall handle single line with several lines`() {
        assertThat(Calibration.calibrate("""
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent()))
            .isEqualTo(142)
    }

}