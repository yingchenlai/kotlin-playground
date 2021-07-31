package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day3Test {

    private val day3 = Day3()

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day3.loadInput("input/day3.txt").isNotEmpty())
    }

    @Test
    fun countTreesForAngle_shouldReturnCorrectAnswerForRight1Down1() {
        val input: List<CharArray> = listOf(
            "..##.......".toCharArray(),
            "#...#...#..".toCharArray(),
            ".#....#..#.".toCharArray(),
            "..#.#...#.#".toCharArray(),
            ".#...##..#.".toCharArray(),
            "..#.##.....".toCharArray(),
            ".#.#.#....#".toCharArray(),
            ".#........#".toCharArray(),
            "#.##...#...".toCharArray(),
            "#...##....#".toCharArray(),
            ".#..#...#.#".toCharArray(),
        )

        assertEquals(2, day3.countTreesForAngle(1, 1, input))
    }

    @Test
    fun countTreesForAngle_shouldReturnCorrectAnswerForRight3Down1() {
        val input: List<CharArray> = listOf(
            "..##.......".toCharArray(),
            "#...#...#..".toCharArray(),
            ".#....#..#.".toCharArray(),
            "..#.#...#.#".toCharArray(),
            ".#...##..#.".toCharArray(),
            "..#.##.....".toCharArray(),
            ".#.#.#....#".toCharArray(),
            ".#........#".toCharArray(),
            "#.##...#...".toCharArray(),
            "#...##....#".toCharArray(),
            ".#..#...#.#".toCharArray(),
        )

        assertEquals(7, day3.countTreesForAngle(3, 1, input))
    }

    @Test
    fun countTreesForAngle_shouldReturnCorrectAnswerForRight5Down1() {
        val input: List<CharArray> = listOf(
            "..##.......".toCharArray(),
            "#...#...#..".toCharArray(),
            ".#....#..#.".toCharArray(),
            "..#.#...#.#".toCharArray(),
            ".#...##..#.".toCharArray(),
            "..#.##.....".toCharArray(),
            ".#.#.#....#".toCharArray(),
            ".#........#".toCharArray(),
            "#.##...#...".toCharArray(),
            "#...##....#".toCharArray(),
            ".#..#...#.#".toCharArray(),
        )

        assertEquals(3, day3.countTreesForAngle(5, 1, input))
    }

    @Test
    fun countTreesForAngle_shouldReturnCorrectAnswerForRight7Down1() {
        val input: List<CharArray> = listOf(
            "..##.......".toCharArray(),
            "#...#...#..".toCharArray(),
            ".#....#..#.".toCharArray(),
            "..#.#...#.#".toCharArray(),
            ".#...##..#.".toCharArray(),
            "..#.##.....".toCharArray(),
            ".#.#.#....#".toCharArray(),
            ".#........#".toCharArray(),
            "#.##...#...".toCharArray(),
            "#...##....#".toCharArray(),
            ".#..#...#.#".toCharArray(),
        )

        assertEquals(4, day3.countTreesForAngle(7, 1, input))
    }

    @Test
    fun countTreesForAngle_shouldReturnCorrectAnswerForRight1Down2() {
        val input: List<CharArray> = listOf(
            "..##.......".toCharArray(),
            "#...#...#..".toCharArray(),
            ".#....#..#.".toCharArray(),
            "..#.#...#.#".toCharArray(),
            ".#...##..#.".toCharArray(),
            "..#.##.....".toCharArray(),
            ".#.#.#....#".toCharArray(),
            ".#........#".toCharArray(),
            "#.##...#...".toCharArray(),
            "#...##....#".toCharArray(),
            ".#..#...#.#".toCharArray(),
        )

        assertEquals(2, day3.countTreesForAngle(1, 2, input))
    }

    @Test
    fun findPath_shouldReturnCorrectPathForRight1Down2() {
        val input: List<CharArray> = listOf(
            "..##.......".toCharArray(),
            "#...#...#..".toCharArray(),
            ".#....#..#.".toCharArray(),
            "..#.#...#.#".toCharArray(),
            ".#...##..#.".toCharArray(),
            "..#.##.....".toCharArray(),
            ".#.#.#....#".toCharArray(),
            ".#........#".toCharArray(),
            "#.##...#...".toCharArray(),
            "#...##....#".toCharArray(),
            ".#..#...#.#".toCharArray(),
        )

        assertEquals(listOf('.', '#', '.', '#', '.', '.'), day3.findPath(1, 2, input))
    }

    @Test
    fun findPath_shouldReturnCorrectPathForRight7Down1() {
        val input: List<CharArray> = listOf(
            "..##.......".toCharArray(),
            "#...#...#..".toCharArray(),
            ".#....#..#.".toCharArray(),
            "..#.#...#.#".toCharArray(),
            ".#...##..#.".toCharArray(),
            "..#.##.....".toCharArray(),
            ".#.#.#....#".toCharArray(),
            ".#........#".toCharArray(),
            "#.##...#...".toCharArray(),
            "#...##....#".toCharArray(),
            ".#..#...#.#".toCharArray(),
        )

        assertEquals(listOf('.', '.', '.', '#', '#','#', '.','.', '.','.', '#'), day3.findPath(7, 1, input))
    }

}