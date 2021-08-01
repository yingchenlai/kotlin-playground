package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day6Test {

    private val day6 = Day6()

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day6.loadInput("input/day6.txt").isNotEmpty())
    }

    @Test
    fun countUniqueAlphabets() {
        val input = listOf(
            "abc",
            "abd",
            "e"
        )
        with(day6) {
            assertEquals(5, input.countUniqueAlphabets())
        }
    }

    @Test
    fun countCommonAlphabets() {
        val input = listOf(
            "abc",
            "abd",
            "a"
        )
        with(day6) {
            assertEquals(1, input.countCommonAlphabets())
        }
    }
}