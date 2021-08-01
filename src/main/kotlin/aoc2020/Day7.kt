package aoc2020

import graph.algorithm.dfs.DepthFirstSearchRecursive
import graph.implementation.AdjacencyList
import graph.structure.Graph
import java.io.File

class Day7 {

    fun run() {
        val input = this.loadInput("input/day7.txt")
        println("day 7 answer part 1: ${getPart1Answer(input)}")
        println("day 7 answer part 2: ${getPart2Answer(input)}")
    }

    fun loadInput(path: String): List<Bag> = File(path)
        .useLines { it.toList() }
        .map { it.toBag() }

    /**
     * Return total number of bags contained by starting bag.
     */
    private fun Graph<String>.part2Traversal(start: String): Int {
        val pushed = mutableSetOf<String>()
        return part2TraversalRecursion(start, 0, pushed)
    }

    private fun Graph<String>.part2TraversalRecursion(
        source: String,
        totalBags: Int,
        pushed: MutableSet<String>
    ): Int
    {
        pushed.add(source)
        val neighbors = getEdges(source)
        val additionalBags = neighbors.sumOf {
            if (it.weight > 0) {
                it.weight.toInt() * part2TraversalRecursion(it.destination, 1, pushed)
            } else 0
        }
        return totalBags + additionalBags
    }

    fun getPart2Answer(bags: List<Bag>): Int {
        val graph = bags.toGraph(Direction.PointToChild)
        return graph.part2Traversal("shiny gold")
    }

    fun getPart1Answer(bags: List<Bag>): Int {
        val graph = bags.toGraph(Direction.PointToParent)
        val dfs = DepthFirstSearchRecursive<String>()
        with(dfs) {
            return graph.depthFirstSearch("shiny gold").visitedVertices.size - 1
        }
    }

    private fun List<Bag>.toGraph(direction: Direction): Graph<String> {
        val graph = AdjacencyList<String>()
        this.forEach {
            run {
                if (!graph.hasVertex(it.name)) {
                    graph.createVertex(it.name)
                }
                it.children.forEach { (childName, quantity) ->
                    run {
                        if (!graph.hasVertex(childName)) {
                            graph.createVertex(childName)
                        }
                        when (direction) {
                            Direction.PointToParent -> graph.addDirectedEdge(childName, it.name, quantity.toDouble())
                            Direction.PointToChild -> graph.addDirectedEdge(it.name, childName, quantity.toDouble())
                        }
                    }
                }
            }
        }
        return graph
    }

    /**
     * Convert a string, e.g. "dark maroon bags contain 2 striped silver bags, 4 mirrored maroon bags, 5 shiny gold bags, 1 dotted gold bag."
     * to a bag.
     */
    fun String.toBag(): Bag {
        val (selfString, childrenString) = this.split("contain", limit = 2)
        return Bag(selfString.getBagName(), childrenString.getChildren())
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

    private fun String.getChildren(): Map<String, Int> {
        val childrenStrings = this.split(",")
        return childrenStrings.associate { it.getBagName() to it.getBagQuantity() }
    }

}

/**
 * Each bag has a name, and a map of children where each entry specifies the name and quantity of each child.
 */
data class Bag(val name: String, val children: Map<String, Int>)

enum class Direction {
    PointToParent,
    PointToChild
}