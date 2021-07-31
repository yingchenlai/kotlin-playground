package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day2Test {

    private val day2 = Day2()

    @Test
    fun toDay2Input_shouldConvertStringToDay2Input() {
        val day2Input = Day2Input(minOccurrence = 15, maxOccurrence = 19, character = 'k', password = "kkkkkkkkkkkkzkkkkkkk")
        with(Day2()) {
            assertEquals(day2Input, "15-19 k: kkkkkkkkkkkkzkkkkkkk".toDay2Input())
        }
    }

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day2.loadInput("input/day2.txt").isNotEmpty())
    }

    @Test
    fun isPasswordValid_shouldReturnTrueWhenCharacterAppearanceFrequencyEqualsMinOccurrence() {
        val day2Input = Day2Input(minOccurrence = 3, maxOccurrence = 5, character = 'k', password = "jrlfkkkiro")
        assertTrue(day2.isPasswordValid(day2Input))
    }

    @Test
    fun isPasswordValid_shouldReturnTrueWhenCharacterAppearanceFrequencyEqualsMaxOccurrence() {
        val day2Input = Day2Input(minOccurrence = 3, maxOccurrence = 5, character = 'k', password = "jrlfkkkkkiro")
        assertTrue(day2.isPasswordValid(day2Input))
    }

    @Test
    fun isPasswordValid_shouldReturnTrueWhenCharacterAppearanceFrequencyIsBetweenMinAndMaxOccurrenceRange() {
        val day2Input = Day2Input(minOccurrence = 3, maxOccurrence = 5, character = 'k', password = "jrlfkkkkiro")
        assertTrue(day2.isPasswordValid(day2Input))
    }

    @Test
    fun isPasswordValid_shouldReturnFalseWhenCharacterAppearanceFrequencyIsLessThanMinOccurrence() {
        val day2Input = Day2Input(minOccurrence = 3, maxOccurrence = 5, character = 'k', password = "jrlfkkiro")
        assertFalse(day2.isPasswordValid(day2Input))
    }

    @Test
    fun isPasswordValid_shouldReturnFalseWhenCharacterAppearanceFrequencyIsMoreThanMaxOccurrence() {
        val day2Input = Day2Input(minOccurrence = 3, maxOccurrence = 5, character = 'k', password = "jrlfkkkkkkiro")
        assertFalse(day2.isPasswordValid(day2Input))
    }

}