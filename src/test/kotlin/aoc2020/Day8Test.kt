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

    @Test
    fun getPart1Answer() {
        val input = listOf(
            Instruction(Command.nop, 0),
            Instruction(Command.acc, 1),
            Instruction(Command.jmp, 4),
            Instruction(Command.acc, 3),
            Instruction(Command.jmp, -3),
            Instruction(Command.acc, -99),
            Instruction(Command.acc, 1),
            Instruction(Command.jmp, -4),
            Instruction(Command.acc, 6),
        )
        with(day8) {
            assertEquals(5, input.getPart1Answer())
        }
    }
}