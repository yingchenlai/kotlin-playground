package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day9Test {

    private val day9 = Day9()

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day9.loadInput("input/day9.txt").isNotEmpty())
    }

    @Test
    fun getPart1Answer() {
        val input = listOf<Long>(
            35,
            20,
            15,
            25,
            47,
            40,
            62,
            55,
            65,
            95,
            102,
            117,
            150,
            182,
            127,
            219,
            299,
            277,
            309,
            576
        )
        with(day9) {
            assertEquals(127, input.getPart1Answer(5))
        }
    }
}