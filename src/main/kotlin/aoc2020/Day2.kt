package aoc2020

import java.io.File

class Day2 {

    fun loadInput(path: String): List<Day2Input> = File(path)
        .useLines { it.toList() }
        .map{ it.toDay2Input() }

    fun String.toDay2Input(): Day2Input {
        val strings = this.split("-", " ", ": ")
        return Day2Input(minOccurrence = strings[0].toInt(),
            maxOccurrence = strings[1].toInt(),
            character = strings[2].toCharArray()[0],
            password = strings[3]
        )
    }

    fun isPasswordValid(day2Input: Day2Input): Boolean {
        val occurrence = day2Input.password.count { it == day2Input.character }
        return day2Input.minOccurrence <= occurrence && day2Input.maxOccurrence >= occurrence
    }

}

data class Day2Input(val minOccurrence: Int, val maxOccurrence: Int, val character: Char, val password: String)