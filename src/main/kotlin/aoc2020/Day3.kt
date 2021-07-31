package aoc2020

import java.io.File

class Day3 {

    fun run() {
        val input = this.loadInput("input/day3.txt")

        val answerPart1 = this.countTreesOnPath(this.findPath(3, 1, input))
        println("day 3 answer part 1: $answerPart1")

        val answerPart2 = this.countTreesOnPath(this.findPath(1, 1, input)) *
                this.countTreesOnPath(this.findPath(3, 1, input)) *
                this.countTreesOnPath(this.findPath(5, 1, input)) *
                this.countTreesOnPath(this.findPath(7, 1, input)) *
                this.countTreesOnPath(this.findPath(1, 2, input))
        println("day 3 answer part 2: $answerPart2")
    }

    fun loadInput(path: String): List<CharArray> = File(path)
        .useLines { it.toList() }
        .map { it.toCharArray() }

    /**
     * Count how many trees will be encountered on a path.
     */
    fun countTreesOnPath(path: List<Char>): Int =
        path.count { it == '#' }

    /**
     * Return the path traversed.
     */
    fun findPath(rightIncrement: Int, downIncrement: Int, input: List<CharArray>): List<Char> =
        input.filterIndexed { index, row -> index % downIncrement == 0 } // filter rows that are involved in path
            .mapIndexed{ index, row -> row[index * rightIncrement % row.size]} // find the character in each row involved in path
}