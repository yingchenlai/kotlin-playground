package utils

/**
 * Split a list of string by empty lines into groups of non-empty strings.
 */
fun List<String>.splitByEmptyLines(): List<List<String>> {
    val result = mutableListOf<List<String>>()
    var currentChunk = mutableListOf<String>()
    for (i in this.indices) {
        if (this[i].trim().isEmpty()) {
            result.add(currentChunk)
            currentChunk = mutableListOf()
        } else {
            currentChunk.add(this[i])
        }
    }
    if (currentChunk.isNotEmpty()) {
        result.add(currentChunk)
    }
    return result
}