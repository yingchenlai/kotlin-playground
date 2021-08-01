package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day8Test {

    private val day8 = Day8()

    @Test
    fun toInstruction_shouldConvertPositiveNumberCorrectly() {
        val input = "acc +14"
        with(day8) {
            assertEquals(Instruction(Command.acc, 14), input.toInstruction())
        }
    }

    @Test
    fun toInstruction_shouldConvertNegativeNumberCorrectly() {
        val input = "jmp -14"
        with(day8) {
            assertEquals(Instruction(Command.jmp, -14), input.toInstruction())
        }
    }

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day8.loadInput("input/day8.txt").isNotEmpty())
    }
}