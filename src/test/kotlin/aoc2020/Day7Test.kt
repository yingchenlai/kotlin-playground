package aoc2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day7Test {

    private val day7 = Day7()

    @Test
    fun loadInput_shouldReturnNonEmptyList() {
        assertTrue(day7.loadInput("input/day7.txt").isNotEmpty())
    }

    @Test
    fun toBag() {
        val input =
            "dark maroon bags contain 2 striped silver bags, 4 mirrored maroon bags, 5 shiny gold bags, 1 dotted gold bag."
        val expectedResult = Bag(
            "dark maroon", mapOf(
                "striped silver" to 2,
                "mirrored maroon" to 4,
                "shiny gold" to 5,
                "dotted gold" to 1
            )
        )
        with(day7) {
            assertEquals(expectedResult, input.toBag())
        }
    }

    @Test
    fun getPart1Answer() {
        val input = listOf(
            "light red bags contain 1 bright white bag, 2 muted yellow bags.",
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
            "bright white bags contain 1 shiny gold bag.",
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
            "faded blue bags contain no other bags.",
            "dotted black bags contain no other bags.",
        )

        with(day7) {
            assertEquals(4, day7.getPart1Answer(input.map { it.toBag() }))
        }
    }

    @Test
    fun getPart2Answer() {
        val input = listOf(
            "light red bags contain 1 bright white bag, 2 muted yellow bags.",
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
            "bright white bags contain 1 shiny gold bag.",
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
            "faded blue bags contain no other bags.",
            "dotted black bags contain no other bags.",
        )

        with(day7) {
            assertEquals(32, day7.getPart2Answer(input.map { it.toBag() }))
        }
    }
}