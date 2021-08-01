package graph.implementation

import graph.structure.Edge
import graph.structure.Graph

class AdjacencyList<T> : Graph<T> {
    private val adjacencies: HashMap<T,
            MutableList<Edge<T>>> = HashMap()

    override fun createVertex(data: T): T {
        adjacencies[data] = ArrayList()
        return data
    }

    override fun hasVertex(data: T): Boolean = adjacencies.containsKey(data)

    override fun addDirectedEdge(
        source: T, destination: T, weight: Double
    ) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    override fun addUndirectedEdge(
        source: T, destination: T,
        weight: Double
    ) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun toString(): String {
        return buildString { // 1
            adjacencies.forEach { (vertex, edges) -> // 2
                val edgeString = edges.joinToString { it.destination.toString() } // 3
                append("$vertex ---> [ $edgeString ]\n") // 4
            }
        }
    }

    override fun depthFirstSearch(start: T):
            List<T> {
        val visited = arrayListOf<T>() // 1
        val pushed = mutableSetOf<T>() // 2
        depthFirstSearchRecursion(start, visited, pushed) // 3
        return visited
    }

    private fun depthFirstSearchRecursion(
        source: T,
        visited: ArrayList<T>,
        pushed: MutableSet<T>
    ) {
        pushed.add(source) // 1
        visited.add(source)
        val neighbors = edges(source)
        neighbors.forEach { // 2
            if (it.destination !in pushed) {
                depthFirstSearchRecursion(it.destination, visited, pushed) // 3
            }
        }
    }

    private fun edges(source: T): MutableList<Edge<T>> =
        adjacencies[source] ?: mutableListOf()

}