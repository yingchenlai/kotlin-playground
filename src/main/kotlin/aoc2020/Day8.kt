package aoc2020

import java.io.File

class Day8 {

    fun run() {
        val input = this.loadInput("input/day8.txt")
        println("day 8 answer part 1: ${input.getPart1Answer()}")
        println("day 8 answer part 2: ${input.getPart2Answer()}")
    }

    fun loadInput(path: String): List<Instruction> = File(path)
        .useLines { it.toList() }
        .map { it.toInstruction() }

    fun String.toInstruction(): Instruction {
        val (commandString, valueString) = this.split(" ")
        return Instruction(Command.valueOf(commandString), valueString.toInt())
    }

    private fun List<Instruction>.executeInstructions(): InstructionExecutionResult {
        var accumulator = 0
        val isInstructionExecuted: MutableList<Boolean> = MutableList(this.size) { false }
        var index = 0
        while (index < this.size) {
            if (isInstructionExecuted[index]) {
                return InstructionExecutionResult(accumulator, true)
            }
            isInstructionExecuted[index] = true
            when (this[index].command) {
                Command.nop -> index += 1
                Command.acc -> {
                    accumulator += this[index].value
                    index += 1
                }
                Command.jmp -> index += this[index].value
            }
        }
        return InstructionExecutionResult(accumulator, false)
    }

    fun List<Instruction>.getPart2Answer(): Int {
        val potentiallyCorruptedInstructionsWithIndex = this.withIndex()
            .filter { (it.value.command == Command.nop && it.value.value != 0) || it.value.command == Command.jmp }

        val executionResult = potentiallyCorruptedInstructionsWithIndex.map {
            val updatedInstructions: List<Instruction> = this.mapIndexed { index, instruction ->
                if (index == it.index) {
                    when (instruction.command) {
                        Command.jmp -> Instruction(Command.nop, instruction.value)
                        Command.nop -> Instruction(Command.jmp, instruction.value)
                        Command.acc -> instruction
                    }
                }
                else instruction
            }
            updatedInstructions.executeInstructions()
        }

        return executionResult.first { !it.hasInfiniteLoop }.accumulatorValue
    }

    fun List<Instruction>.getPart1Answer(): Int {
        return this.executeInstructions().accumulatorValue
    }

}

data class Instruction(val command: Command, val value: Int)

enum class Command {
    nop,
    acc,
    jmp
}

data class InstructionExecutionResult(val accumulatorValue: Int, val hasInfiniteLoop: Boolean)