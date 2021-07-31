package aoc2020

import java.io.File
import kotlin.math.ceil
import kotlin.math.floor

class Day5 {

    fun run() {
        val input = this.loadInput("input/day5.txt")
        val answerPart1 = input.map { it.toSeat() }.maxOf { it.seatId }
        println("day 5 answer part 1: $answerPart1")
    }

    fun loadInput(path: String): List<CharArray> = File(path)
        .useLines { it.toList() }
        .map { it.toCharArray() }

    fun CharArray.toSeat(): Seat {
        val row = this.slice(0..6).toRow()
        val column = this.slice(7..9).toColumn()
        return Seat(row, column, getSeatId(row, column))
    }

    private fun List<Char>.toRow(): Int {
        return binaryShaving(0, 127, 'F', 'B')
    }

    private fun List<Char>.toColumn(): Int {
        return binaryShaving(0, 7, 'L', 'R')
    }

    /**
     * Shave down an integer range in a binary manner according to a list of commands to take lower or upper half at
     * each step.
     */
    private fun List<Char>.binaryShaving(lowerBound: Int, upperBound: Int, lowerRangeCommand: Char, upperRangeCommand: Char): Int {
        var min = (lowerBound + 1).toDouble()
        var max = (upperBound + 1).toDouble()
        for (i in 0..this.size - 2) {
            if (this[i] == lowerRangeCommand) {
                max = floor((min + max) / 2.0)
            } else if (this[i] == upperRangeCommand) {
                min = ceil((min + max) / 2.0)
            }
        }
        return if (this[this.size - 1] == lowerRangeCommand) {
            (min - 1).toInt()
        } else {
            (max - 1).toInt()
        }
    }

    private fun getSeatId(row: Int, column: Int): Int = row * 8 + column

}

data class Seat(val row: Int, val column: Int, val seatId: Int)