package aoc2020

import java.io.File

class Day4 {

    fun run() {
        val input = this.loadInput("input/day4.txt")

        val answerPart1 = input.count{ it.isValid() }
        println("day 4 answer part 1: $answerPart1")
    }

    fun loadInput(path: String): List<Passport> = File(path)
        .useLines { it.toList().splitByEmptyLines().map { strings -> strings.toPassport() } }

    /**
     * A passport is valid if all fields except cid are not empty.
     * cid does not affect passport validity.
     */
    fun Passport.isValid(): Boolean {
        return (this.byr.isNotEmpty() && this.eyr.isNotEmpty() && this.iyr.isNotEmpty() && this.hcl.isNotEmpty()
                && this.hgt.isNotEmpty() && this.ecl.isNotEmpty() && this.pid.isNotEmpty())
    }

    /**
     * Convert a list of strings specifying a passport to passport.
     */
    fun List<String>.toPassport(): Passport {
        val string = this.joinToString(" ")
        return Passport(
            string.findValueByFieldName("byr"),
            string.findValueByFieldName("iyr"),
            string.findValueByFieldName("eyr"),
            string.findValueByFieldName("hgt"),
            string.findValueByFieldName("hcl"),
            string.findValueByFieldName("ecl"),
            string.findValueByFieldName("pid"),
            string.findValueByFieldName("cid")
        )
    }

    /**
     * Find value by field name in a string with the format "fieldName:value".
     * Value may contain alphanumeric characters or #.
     */
    fun String.findValueByFieldName(fieldName: String): String {
        val regex = """${fieldName}:([#|\w]+)""".toRegex()
        return regex.find(this)?.groupValues?.getOrElse(1) { "" } ?: ""
    }

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

}

data class Passport(
    val byr: String, val iyr: String, val eyr: String, val hgt: String, val hcl: String, val ecl: String,
    val pid: String, val cid: String
)