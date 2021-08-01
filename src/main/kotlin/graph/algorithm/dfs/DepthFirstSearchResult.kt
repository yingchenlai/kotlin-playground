package graph.algorithm.dfs

import graph.structure.Edge

data class DepthFirstSearchResult<T>(val visitedVertices: List<T>, val traversedEdges: List<Edge<T>>)