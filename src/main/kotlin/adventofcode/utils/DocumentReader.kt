package adventofcode.utils

import org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets
import java.util.regex.Pattern

object DocumentReader {

    fun readFromResource(path : String ): List<String> {
        val document = IOUtils.resourceToString(path, StandardCharsets.UTF_8)
        return read(document)
    }

    fun read( document : String) : List<String> {
        return document.split(Pattern.compile("\\r?\\n"))
    }

}