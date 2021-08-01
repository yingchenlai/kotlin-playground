package graph.algorithm.dfs

import graph.structure.Edge
import graph.structure.Graph

class DepthFirstSearchRecursive<T>: DepthFirstSearch<T> {

    override fun Graph<T>.depthFirstSearch(start: T): DepthFirstSearchResult<T> {
        val visitedVertices = arrayListOf<T>()
        val traversedEdges = arrayListOf<Edge<T>>()
        val pushed = mutableSetOf<T>()
        depthFirstSearchRecursion(start, visitedVertices, traversedEdges, pushed)
        return DepthFirstSearchResult(visitedVertices, traversedEdges)
    }

    private fun Graph<T>.depthFirstSearchRecursion(
        source: T,
        visited: ArrayList<T>,
        traversedEdges: ArrayList<Edge<T>>,
        pushed: MutableSet<T>
    ) {
        pushed.add(source)
        visited.add(source)
        val neighbors = getEdges(source)
        neighbors.forEach {
            if (it.destination !in pushed) {
                traversedEdges.add(it)
                depthFirstSearchRecursion(it.destination, visited, traversedEdges, pushed)
            }
        }
    }


}