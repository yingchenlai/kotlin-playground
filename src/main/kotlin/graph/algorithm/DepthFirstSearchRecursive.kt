package graph.algorithm

import graph.structure.Graph

class DepthFirstSearchRecursive<T>: DepthFirstSearch<T> {

    override fun Graph<T>.depthFirstSearch(start: T): List<T> {
        val visited = arrayListOf<T>() // 1
        val pushed = mutableSetOf<T>() // 2
        depthFirstSearchRecursion(start, visited, pushed) // 3
        return visited
    }

    private fun Graph<T>.depthFirstSearchRecursion(
        source: T,
        visited: ArrayList<T>,
        pushed: MutableSet<T>
    ) {
        pushed.add(source) // 1
        visited.add(source)
        val neighbors = getEdges(source)
        neighbors.forEach { // 2
            if (it.destination !in pushed) {
                depthFirstSearchRecursion(it.destination, visited, pushed) // 3
            }
        }
    }


}