package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day4Test {

    private val day4 = Day4()

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day4.loadInput("input/day4.txt").isNotEmpty())
    }

    @Test
    fun splitByEmptyLines_ShouldReturnCorrectSplitList() {
        val input = listOf("First line", "Second line", "\n", "Third line", "\n")
        val expectedResult = listOf(
            listOf("First line", "Second line"),
            listOf("Third line")
        )

        with(Day4()) {
            assertEquals(expectedResult, input.splitByEmptyLines())
        }
    }

    @Test
    fun toPassports_shouldReturnCorrectPassports() {
        val input = listOf(
            "byr:1971",
            "iyr:2017 hgt:160cm",
            "eyr:2020 ecl:hzl",
            "pid:157096267"
        )
        val expectedResult = Passport("1971", "2017", "2020", "160cm", "", "hzl", "157096267", "")

        with(Day4()) {
            assertEquals(expectedResult, input.toPassport())
        }
    }

    @Test
    fun findValueByFieldName_shouldFindByrValue() {
        val string = "byr:1971 iyr:2017 hgt:160cm"
        with(Day4()) {
            assertEquals("1971", string.findValueByFieldName("byr"))
        }
    }
}