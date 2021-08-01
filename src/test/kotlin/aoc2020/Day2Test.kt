package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day2Test {

    private val day2 = Day2()

    @Test
    fun toDay2Input_shouldConvertStringToDay2Input() {
        val day2Input = Day2Input(firstNumber = 15, secondNumber = 19, character = 'k', password = "kkkkkkkkkkkkzkkkkkkk")
        with(day2) {
            assertEquals(day2Input, "15-19 k: kkkkkkkkkkkkzkkkkkkk".toDay2Input())
        }
    }

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day2.loadInput("input/day2.txt").isNotEmpty())
    }

    @Test
    fun isPasswordValidAccordingToOldPolicy_shouldReturnTrueWhenCharacterAppearanceFrequencyEqualsMinOccurrence() {
        val day2Input = Day2Input(firstNumber = 3, secondNumber = 5, character = 'k', password = "jrlfkkkiro")
        assertTrue(day2.isPasswordValidAccordingToOldPolicy(day2Input))
    }

    @Test
    fun isPasswordValidAccordingToOldPolicy_shouldReturnTrueWhenCharacterAppearanceFrequencyEqualsMaxOccurrence() {
        val day2Input = Day2Input(firstNumber = 3, secondNumber = 5, character = 'k', password = "jrlfkkkkkiro")
        assertTrue(day2.isPasswordValidAccordingToOldPolicy(day2Input))
    }

    @Test
    fun isPasswordValidAccordingToOldPolicy_shouldReturnTrueWhenCharacterAppearanceFrequencyIsBetweenMinAndMaxOccurrenceRange() {
        val day2Input = Day2Input(firstNumber = 3, secondNumber = 5, character = 'k', password = "jrlfkkkkiro")
        assertTrue(day2.isPasswordValidAccordingToOldPolicy(day2Input))
    }

    @Test
    fun isPasswordValidAccordingToOldPolicy_shouldReturnFalseWhenCharacterAppearanceFrequencyIsLessThanMinOccurrence() {
        val day2Input = Day2Input(firstNumber = 3, secondNumber = 5, character = 'k', password = "jrlfkkiro")
        assertFalse(day2.isPasswordValidAccordingToOldPolicy(day2Input))
    }

    @Test
    fun isPasswordValidAccordingToOldPolicy_shouldReturnFalseWhenCharacterAppearanceFrequencyIsMoreThanMaxOccurrence() {
        val day2Input = Day2Input(firstNumber = 3, secondNumber = 5, character = 'k', password = "jrlfkkkkkkiro")
        assertFalse(day2.isPasswordValidAccordingToOldPolicy(day2Input))
    }

    @Test
    fun isPasswordValidAccordingToNewPolicy_shouldReturnTrueWhenCharacterAppearsAtFirstIndex() {
        val day2Input = Day2Input(firstNumber = 3, secondNumber = 5, character = 'k', password = "jrkfykkkiro")
        assertTrue(day2.isPasswordValidAccordingToNewPolicy(day2Input))
    }

    @Test
    fun isPasswordValidAccordingToNewPolicy_shouldReturnTrueWhenCharacterAppearsAtSecondIndex() {
        val day2Input = Day2Input(firstNumber = 3, secondNumber = 5, character = 'k', password = "jrfukekkkiro")
        assertTrue(day2.isPasswordValidAccordingToNewPolicy(day2Input))
    }

    @Test
    fun isPasswordValidAccordingToNewPolicy_shouldReturnFalseWhenCharacterAppearsAtNeitherIndex() {
        val day2Input = Day2Input(firstNumber = 3, secondNumber = 5, character = 'k', password = "jrfucekkkiro")
        assertFalse(day2.isPasswordValidAccordingToNewPolicy(day2Input))
    }

    @Test
    fun isPasswordValidAccordingToNewPolicy_shouldReturnFalseWhenCharacterAppearsAtBothIndices() {
        val day2Input = Day2Input(firstNumber = 3, secondNumber = 5, character = 'k', password = "jrkukekkkiro")
        assertFalse(day2.isPasswordValidAccordingToNewPolicy(day2Input))
    }
}