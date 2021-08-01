package aoc2020

import java.io.File

class Day7 {

    fun loadInput(path: String): List<Bag> = File(path)
        .useLines { it.toList() }
        .map { it.toBag() }

    /**
     * Convert a string, e.g. "dark maroon bags contain 2 striped silver bags, 4 mirrored maroon bags, 5 shiny gold bags, 1 dotted gold bag."
     * to a bag.
     */
    fun String.toBag(): Bag {
        val (parentString, childrenString) = this.split("contain", limit = 2)
        return Bag(parentString.getBagName(), childrenString.findChildren())
    }

    /**
     * Extract bag name from a string,
     * e.g. "dark maroon bags" --> return "dark maroon"
     * e.g. "dotted gold bag" --> return "dotted gold"
     */
    private fun String.getBagName(): String {
        val regex = """([a-z]+[a-z ]*) bags?""".toRegex()
        return regex.find(this)?.groupValues?.getOrElse(1) { "" } ?: ""
    }

    /**
     * Extract the quantity of a bag from a string,
     * e.g. "2 striped silver bags" --> return 2
     * e.g. "1 dotted gold bag" --> return 1
     */
    private fun String.getBagQuantity(): Int {
        val regex = """[0-9]+""".toRegex()
        return regex.find(this)?.groupValues?.getOrElse(0) { "0" }?.toInt() ?: 0
    }

    private fun String.findChildren(): Map<String, Int> {
        val childrenStrings = this.split(",")
        return childrenStrings.associate { it.getBagName() to it.getBagQuantity()}
    }

}

/**
 * Each bag has a name, and a map of children where each entry specifies the name and quantity of each child.
 */
data class Bag(val name: String, val children: Map<String, Int>)