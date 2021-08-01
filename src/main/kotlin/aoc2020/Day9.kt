package aoc2020

import org.paukov.combinatorics3.Generator.combination
import java.io.File

class Day9 {

    fun run() {
        val input = this.loadInput("input/day9.txt")
        println("day 9 answer part 1: ${input.getPart1Answer(25)}")
//        println("day 8 answer part 2: ${input.getPart2Answer()}")
    }

    fun loadInput(path: String): List<Long> = File(path)
        .useLines { it.toList() }
        .map{ it.toLong() }

    private fun List<Long>.getCombinations(combinationSize: Int): List<List<Long>> {
        return combination(this)
            .simple(combinationSize)
            .stream()
            .toList()
    }

    private fun isNumberValid(number: Long, preamble: List<Long>): Boolean {
        val validValues = preamble.getCombinations(2).map{ it.sum() }
        return number in validValues
    }

    fun List<Long>.getPart1Answer(preambleSize: Int): Long {
        var index = preambleSize
        while (isNumberValid(this[index], this.subList(index - preambleSize, index))) {
            index += 1
        }
        return this[index]
    }
}