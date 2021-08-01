package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day5Test {

    private val day5 = Day5()

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day5.loadInput("input/day5.txt").isNotEmpty())
    }

    @Test
    fun toSeat_shouldReturnCorrectResultForTestCase1() {
        val expectedResult = Seat(70, 7, 567)
        with(Day5()) {
            assertEquals(expectedResult, "BFFFBBFRRR".toCharArray().toSeat())
        }
    }

    @Test
    fun toSeat_shouldReturnCorrectResultForTestCase2() {
        val expectedResult = Seat(14, 7, 119)
        with(Day5()) {
            assertEquals(expectedResult, "FFFBBBFRRR".toCharArray().toSeat())
        }
    }

    @Test
    fun toSeat_shouldReturnCorrectResultForTestCase3() {
        val expectedResult = Seat(102, 4, 820)
        with(Day5()) {
            assertEquals(expectedResult, "BBFFBBFRLL".toCharArray().toSeat())
        }
    }

    @Test
    fun findMissingSeatIds() {
        val input = listOf(
            Seat(1, 0, 8),
            Seat(1, 1, 9),
            Seat(1, 2, 10),
            Seat(1, 3, 11),
            Seat(1, 4, 12),
            Seat(1, 5, 13),
            Seat(1, 6, 14),
        )
        with(Day5()) {
            assertNotNull(input.findMissingSeatIds())
        }
    }

}