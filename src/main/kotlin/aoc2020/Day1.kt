package aoc2020

import org.paukov.combinatorics3.Generator
import java.io.File

class Day1() {

    fun run() {
        val day1Input = this.loadInput("input/day1.txt")
        val multipleOfTwo = this.findMultipleOfTwoNumbersThatAddUpTo2020(day1Input)
        val multipleOfThree = this.findMultipleOfThreeNumbersThatAddUpTo2020(day1Input)
        println("multiple of two: $multipleOfTwo")
        println("multiple of three: $multipleOfThree")
    }

    fun loadInput(path: String): List<Int> = File(path)
            .useLines { it.toList() }
            .map{ it.toInt() }

    fun findMultipleOfTwoNumbersThatAddUpTo2020(input: List<Int>): Int {
        val sortedList = input.sorted()
        var smallIndex = 0
        var bigIndex = input.size - 1
        var sum = sortedList[smallIndex] + sortedList[bigIndex]
        while (sum != 2020) {
            if (sum < 2020) {
                smallIndex += 1
            }
            else {
                bigIndex -= 1
            }
            sum = sortedList[smallIndex] + sortedList[bigIndex]
        }
        return sortedList[smallIndex] * sortedList[bigIndex]
    }

    fun findMultipleOfThreeNumbersThatAddUpTo2020(input: List<Int>): Int {
        val combinations: List<List<Int>> = Generator.combination(input)
            .simple(3)
            .stream()
            .toList()

        combinations.forEach{
            if (it.sum() == 2020) {
                return it.reduce{first, second -> first * second}
            }
        }

        return -1
    }

}