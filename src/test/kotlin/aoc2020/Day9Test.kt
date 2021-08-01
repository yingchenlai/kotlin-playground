package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day9Test {

    private val day9 = Day9()

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day9.loadInput("input/day9.txt").isNotEmpty())
    }
}