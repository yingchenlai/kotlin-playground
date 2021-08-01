package graph.structure

data class Edge<T>(
    val source: T,
    val destination: T,
    val weight: Double = 1.0
)