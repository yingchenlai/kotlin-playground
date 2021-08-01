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

    override fun getEdges(source: T): List<Edge<T>> =
        adjacencies[source] ?: emptyList()

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

}