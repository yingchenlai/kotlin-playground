package graph.algorithm.dfs

import graph.structure.Graph

interface DepthFirstSearch<T> {
    fun Graph<T>.depthFirstSearch(start: T): DepthFirstSearchResult<T>
}

