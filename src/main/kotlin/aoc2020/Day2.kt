package aoc2020

import java.io.File

class Day2 {

    fun run() {
        val day2Input = this.loadInput("input/day2.txt")
        val answerPart1 = day2Input.count{ this.isPasswordValidAccordingToOldPolicy(it) }
        println("day 2 answer part 1: $answerPart1")
        val answerPart2 = day2Input.count{ this.isPasswordValidAccordingToNewPolicy(it) }
        println("day 2 answer part 2: $answerPart2")
    }

    fun loadInput(path: String): List<Day2Input> = File(path)
        .useLines { it.toList() }
        .map{ it.toDay2Input() }

    fun String.toDay2Input(): Day2Input {
        val strings = this.split("-", " ", ": ")
        return Day2Input(firstNumber = strings[0].toInt(),
            secondNumber = strings[1].toInt(),
            character = strings[2].toCharArray()[0],
            password = strings[3]
        )
    }

    /**
     * According to old policy, first number describes the min occurrence of character in password,
     * and second number describes the max occurrence.
     */
    fun isPasswordValidAccordingToOldPolicy(day2Input: Day2Input): Boolean {
        val occurrence = day2Input.password.count { it == day2Input.character }
        return day2Input.firstNumber <= occurrence && day2Input.secondNumber >= occurrence
    }

    /**
     * According to new policy, character must appear at the index specified by only the first or second number (1-indexed).
     */
    fun isPasswordValidAccordingToNewPolicy(day2Input: Day2Input): Boolean {
        val passwordCharArray = day2Input.password.toCharArray()
        val isCharacterAtFirstIndex = passwordCharArray[day2Input.firstNumber - 1] == day2Input.character
        val isCharacterAtSecondIndex = passwordCharArray[day2Input.secondNumber - 1] == day2Input.character
        return isCharacterAtFirstIndex.xor(isCharacterAtSecondIndex)
    }

}

data class Day2Input(val firstNumber: Int, val secondNumber: Int, val character: Char, val password: String)