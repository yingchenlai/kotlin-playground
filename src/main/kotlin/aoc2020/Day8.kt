package aoc2020

import java.io.File

class Day8 {

    fun run() {
        val input = this.loadInput("input/day8.txt")
        println("day 8 answer part 1: ${input.getPart1Answer()}")
//        println("day 7 answer part 2: ${getPart2Answer(input)}")
    }

    fun loadInput(path: String): List<Instruction> = File(path)
        .useLines { it.toList() }
        .map{ it.toInstruction() }

    fun String.toInstruction(): Instruction {
        val (commandString, valueString) = this.split(" ")
        return Instruction(Command.valueOf(commandString), valueString.toInt())
    }

    fun List<Instruction>.getPart1Answer(): Int {
        var accumulator = 0
        val isInstructionExecuted: MutableList<Boolean> = MutableList(this.size) {false}
        var index = 0
        while(!isInstructionExecuted[index]) {
            isInstructionExecuted[index] = true
            when(this[index].command) {
                Command.nop -> index += 1
                Command.acc -> {
                    accumulator += this[index].value
                    index += 1
                }
                Command.jmp -> index += this[index].value
            }
        }
        return accumulator
    }


}

data class Instruction(val command: Command, val value: Int)

enum class Command {
    nop,
    acc,
    jmp
}