package aoc2020

import java.io.File

class Day9 {

    fun loadInput(path: String): List<Long> = File(path)
        .useLines { it.toList() }
        .map{ it.toLong() }


}