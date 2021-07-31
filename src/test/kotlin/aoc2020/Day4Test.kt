package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day4Test {

    private val day4 = Day4()

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day4.loadInput("input/day4.txt").isNotEmpty())
        assertTrue(day4.loadInput("input/day4.txt").size > 3)
        println(day4.loadInput("input/day4.txt"))
        println(day4.loadInput("input/day4.txt").size)
    }

    @Test
    fun shouldReturnCorrectAnswerForSampleTestCase() {
        val input = listOf(
            "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
            "byr:1937 iyr:2017 cid:147 hgt:183cm",
            "\n",
            "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
            "hcl:#cfa07d byr:1929",
            "\n",
            "hcl:#ae17e1 iyr:2013",
            "eyr:2024",
            "ecl:brn pid:760753108 byr:1931",
            "hgt:179cm",
            "\n",
            "hcl:#cfa07d eyr:2025 pid:166559648",
            "iyr:2011 ecl:brn hgt:59in"
        )
        with(Day4()) {
            assertEquals(2, input.splitByEmptyLines().map { it.toPassport() }.count{ it.isValid() })
        }
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

    @Test
    fun findValueByFieldName_shouldFindHclValue() {
        val string = "byr:1971 iyr:2017 hgt:160cm hcl:#fffffd"
        with(Day4()) {
            assertEquals("#fffffd", string.findValueByFieldName("hcl"))
        }
    }

    @Test
    fun isValid_shouldReturnTrueWhenAllFieldsOfAPassportAreFilledExceptCid() {
        val input = Passport("1971", "2017", "2020", "160cm", "hzl", "hzl", "157096267", "")
        with(Day4()) {
            assertTrue(input.isValid())
        }
    }

    @Test
    fun isValid_shouldReturnFalseWhenByrIsEmpty() {
        val input = Passport("", "2017", "2020", "160cm", "hzl", "hzl", "157096267", "")
        with(Day4()) {
            assertFalse(input.isValid())
        }
    }
}