package adventofcode.day01

import org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

fun main(args: Array<String>) {
    val document = IOUtils.resourceToString("/adventofcode/day01/input.txt", StandardCharsets.UTF_8)
    val calibration = Calibration.calibrate(document)
    println("Calibration $calibration")
}
