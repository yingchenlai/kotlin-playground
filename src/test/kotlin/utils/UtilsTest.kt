package utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UtilsTest {

    @Test
    fun splitByEmptyLines_ShouldReturnCorrectSplitList() {
        val input = listOf("First line", "Second line", "\n", "Third line", "\n")
        val expectedResult = listOf(
            listOf("First line", "Second line"),
            listOf("Third line")
        )

        assertEquals(expectedResult, input.splitByEmptyLines())
    }


}