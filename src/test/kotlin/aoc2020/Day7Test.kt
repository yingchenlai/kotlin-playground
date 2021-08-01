package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day7Test {

    private val day7 = Day7()

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day7.loadInput("input/day7.txt").isNotEmpty())
    }

    @Test
    fun toBag() {
        val input = "dark maroon bags contain 2 striped silver bags, 4 mirrored maroon bags, 5 shiny gold bags, 1 dotted gold bag."
        val expectedResult = Bag("dark maroon", mapOf(
            "striped silver" to 2,
            "mirrored maroon" to 4,
            "shiny gold" to 5,
            "dotted gold" to 1
        ))
        with(Day7()) {
            assertEquals(expectedResult, input.toBag())
        }

    }
}