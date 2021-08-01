package aoc2020

import utils.splitByEmptyLines
import java.io.File

class Day6 {

    fun run() {
        val input = this.loadInput("input/day6.txt")
        val answerPart1 = input.sumOf { it.countUniqueAlphabets() }
        println("day 6 answer part 1: $answerPart1")
        val answerPart2 = input.sumOf { it.countCommonAlphabets() }
        println("day 6 answer part 2: $answerPart2")
    }


    /**
     * Load input file into a nested list of strings, where the input file is split by empty lines into groups of non-empty lines.
     */
    fun loadInput(path: String): List<List<String>> = File(path)
        .useLines { it.toList().splitByEmptyLines() }

    /**
     * Return the number of unique alphabets in the list of strings.
     */
    fun List<String>.countUniqueAlphabets(): Int = this.flatMap { it.toList() }.toSet().size

    /**
     * Count the number of alphabets shared by all strings.
     */
    fun List<String>.countCommonAlphabets(): Int = this.map { it.toSet() }.reduce{ first, second -> first.intersect(second)}.size

}