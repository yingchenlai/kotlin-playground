package aoc2020

import java.io.File

class Day8 {

    fun loadInput(path: String): List<Instruction> = File(path)
        .useLines { it.toList() }
        .map{ it.toInstruction() }

    fun String.toInstruction(): Instruction {
        val (commandString, valueString) = this.split(" ")
        return Instruction(Command.valueOf(commandString), valueString.toInt())
    }



}

data class Instruction(val command: Command, val value: Int)

enum class Command {
    nop,
    acc,
    jmp
}