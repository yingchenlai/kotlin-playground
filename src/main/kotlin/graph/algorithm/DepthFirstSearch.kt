package graph.algorithm

import graph.structure.Graph

interface DepthFirstSearch<T> {
    /**
     * Return the list of visited vertices.
     */
    fun Graph<T>.depthFirstSearch(start: T): List<T>
}