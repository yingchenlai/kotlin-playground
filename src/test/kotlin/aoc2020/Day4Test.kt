package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.splitByEmptyLines

internal class Day4Test {

    private val day4 = Day4()

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day4.loadInput("input/day4.txt").isNotEmpty())
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
        with(day4) {
            assertEquals(2, input.splitByEmptyLines().map { it.toPassport() }.count{ it.isValid() })
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

        with(day4) {
            assertEquals(expectedResult, input.toPassport())
        }
    }

    @Test
    fun findValueByFieldName_shouldFindByrValue() {
        val string = "byr:1971 iyr:2017 hgt:160cm"
        with(day4) {
            assertEquals("1971", string.findValueByFieldName("byr"))
        }
    }

    @Test
    fun findValueByFieldName_shouldFindHclValue() {
        val string = "byr:1971 iyr:2017 hgt:160cm hcl:#fffffd"
        with(day4) {
            assertEquals("#fffffd", string.findValueByFieldName("hcl"))
        }
    }

    @Test
    fun isValid_shouldReturnTrueWhenAllFieldsOfAPassportAreFilledExceptCid() {
        val input = Passport("1971", "2017", "2020", "160cm", "hzl", "hzl", "157096267", "")
        with(day4) {
            assertTrue(input.isValid())
        }
    }

    @Test
    fun isValid_shouldReturnFalseWhenByrIsEmpty() {
        val input = Passport("", "2017", "2020", "160cm", "hzl", "hzl", "157096267", "")
        with(day4) {
            assertFalse(input.isValid())
        }
    }

    @Test
    fun isValidByr_shouldReturnTrueFor1930() {
        with(day4) {
            assertTrue("1930".isValidByr())
        }
    }

    @Test
    fun isValidByr_shouldReturnTrueFor1920() {
        with(day4) {
            assertTrue("1920".isValidByr())
        }
    }

    @Test
    fun isValidByr_shouldReturnTrueFor2002() {
        with(day4) {
            assertTrue("2002".isValidByr())
        }
    }

    @Test
    fun isValidByr_shouldReturnFalseFor1919() {
        with(day4) {
            assertFalse("1919".isValidByr())
        }
    }

    @Test
    fun isValidByr_shouldReturnFalseFor2003() {
        with(day4) {
            assertFalse("2003".isValidByr())
        }
    }

    @Test
    fun isValidIyr_shouldReturnTrueFor2010() {
        with(day4) {
            assertTrue("2010".isValidIyr())
        }
    }

    @Test
    fun isValidIyr_shouldReturnFalseFor2009() {
        with(day4) {
            assertFalse("2009".isValidIyr())
        }
    }

    @Test
    fun isValidIyr_shouldReturnFalseFor2021() {
        with(day4) {
            assertFalse("2021".isValidIyr())
        }
    }

    @Test
    fun isValidEyr_shouldReturnTrueFor2020() {
        with(day4) {
            assertTrue("2020".isValidEyr())
        }
    }

    @Test
    fun isValidEyr_shouldReturnFalseFor2019() {
        with(day4) {
            assertFalse("2019".isValidEyr())
        }
    }

    @Test
    fun isValidEyr_shouldReturnFalseFor2031() {
        with(day4) {
            assertFalse("2031".isValidEyr())
        }
    }

    @Test
    fun isValidHgt_shouldReturnTrueFor193cm() {
        with(day4) {
            assertTrue("193cm".isValidHgt())
        }
    }

    @Test
    fun isValidHgt_shouldReturnTrueFor76in() {
        with(day4) {
            assertTrue("76in".isValidHgt())
        }
    }

    @Test
    fun isValidHgt_shouldReturnFalseFor58in() {
        with(day4) {
            assertFalse("58in".isValidHgt())
        }
    }

    @Test
    fun isValidHgt_shouldReturnFalseFor149cm() {
        with(day4) {
            assertFalse("149cm".isValidHgt())
        }
    }

    @Test
    fun isValidHgt_shouldReturnFalseFor149() {
        with(day4) {
            assertFalse("149".isValidHgt())
        }
    }

    @Test
    fun isValidHcl_shouldReturnTrueForHexColor() {
        with(day4) {
            assertTrue("#3e3e07".isValidHcl())
        }
    }

    @Test
    fun isValidHcl_shouldReturnFalseForNonHexColor() {
        with(day4) {
            assertFalse("blu".isValidHcl())
        }
    }

    @Test
    fun isValidEcl_shouldReturnTrueForAmb() {
        with(day4) {
            assertTrue("amb".isValidEcl())
        }
    }

    @Test
    fun isValidEcl_shouldReturnFalseForHexColor() {
        with(day4) {
            assertFalse("#3e3e07".isValidEcl())
        }
    }

    @Test
    fun isValidPid_shouldReturnTrueFor9Digits() {
        with(day4) {
            assertTrue("699976645".isValidPid())
        }
    }

    @Test
    fun isValidPid_shouldReturnFalseFor10Digits() {
        with(day4) {
            assertFalse("0699976645".isValidPid())
        }
    }

    @Test
    fun isValidPart2_shouldReturnTrueWhenAllFieldsOfAPassportAreFilledAndValidExceptCid() {
        val input = Passport("1971", "2017", "2020", "160cm", "#3e3e07", "hzl", "157096267", "")
        with(day4) {
            assertTrue(input.isValidPart2())
        }
    }

    @Test
    fun isValidPart2_shouldReturnFalseWhenSomeFieldsAreInvalid() {
        val input = Passport("1971", "2021", "2020", "160", "hzl", "hzl", "15709626", "")
        with(day4) {
            assertFalse(input.isValidPart2())
        }
    }

}