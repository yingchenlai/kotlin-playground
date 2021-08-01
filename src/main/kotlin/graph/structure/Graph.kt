package graph.structure

interface Graph<T> {
    fun createVertex(data: T): T

    fun hasVertex(data: T): Boolean

    fun addDirectedEdge(
        source: T,
        destination: T,
        weight: Double = 1.0
    )

    fun addUndirectedEdge(
        source: T,
        destination: T,
        weight: Double = 1.0
    )

    fun depthFirstSearch(start: T): List<T>
}

