package aoc2020

import java.io.File

class Day3 {

    fun run() {
        val input = this.loadInput("input/day3.txt")

        val answerPart1 = this.countTreesOnPath(this.findPath(3, 1, input))
        println("day 3 answer part 1: $answerPart1")

        val answerPart2: Long = countTreesForAngle(1, 1, input) *
                countTreesForAngle(3, 1, input) *
                countTreesForAngle(5, 1, input) *
                countTreesForAngle(7, 1, input) *
                countTreesForAngle(1, 2, input)
        println("day 3 answer part 2: $answerPart2")
    }

    fun loadInput(path: String): List<CharArray> = File(path)
        .useLines { it.toList() }
        .map { it.toCharArray() }

    /**
     * Count the trees encountered for a given angle defined by rightIncrement and downIncrement.
     */
    fun countTreesForAngle(rightIncrement: Int, downIncrement: Int, input: List<CharArray>) =
        this.countTreesOnPath(this.findPath(rightIncrement, downIncrement, input))

    /**
     * Count how many trees will be encountered on a path.
     */
    fun countTreesOnPath(path: List<Char>): Long =
        path.count { it == '#' }.toLong()

    /**
     * Return the path traversed.
     */
    fun findPath(rightIncrement: Int, downIncrement: Int, input: List<CharArray>): List<Char> =
        input.filterIndexed { index, row -> index % downIncrement == 0 } // filter rows that are involved in path
            .mapIndexed{ index, row -> row[index * rightIncrement % row.size]} // find the character in each row involved in path
}