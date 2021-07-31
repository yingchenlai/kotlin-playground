package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day1Test {

    private val day1: Day1 = Day1()

    @Test
    fun findMultipleOfTwoNumbersThatAddUpTo2020_shouldReturn40000WhenPairIs2000And20() {
        assertEquals(40000, day1.findMultipleOfTwoNumbersThatAddUpTo2020(listOf(10, 8, 3, 2000, 879, 334, 20, 6)))
    }

    @Test
    fun findMultipleOfThreeNumbersThatAddUpTo2020_shouldReturn241861950WhenTripleIs979_366And675() {
        assertEquals(241861950, day1.findMultipleOfThreeNumbersThatAddUpTo2020(listOf(1721, 979, 366, 299, 675, 1456)))
    }

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day1.loadInput("input/day1.txt").isNotEmpty())
    }

}