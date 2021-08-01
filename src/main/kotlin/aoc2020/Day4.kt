package aoc2020

import utils.splitByEmptyLines
import java.io.File

class Day4 {

    fun run() {
        val input = this.loadInput("input/day4.txt")

        val answerPart1 = input.count { it.isValid() }
        println("day 4 answer part 1: $answerPart1")

        val answerPart2 = input.count { it.isValidPart2() }
        println("day 4 answer part 2: $answerPart2")
    }

    fun loadInput(path: String): List<Passport> = File(path)
        .useLines { it.toList().splitByEmptyLines().map { strings -> strings.toPassport() } }

    /**
     * In Part 2, a passport is valid if all fields except cid are not empty, and each field meets the validity
     * criteria for individual fields.
     * cid does not affect passport validity.
     */
    fun Passport.isValidPart2(): Boolean {
        return (this.byr.isValidByr() && this.eyr.isValidEyr() && this.iyr.isValidIyr() && this.hcl.isValidHcl()
                && this.hgt.isValidHgt() && this.ecl.isValidEcl() && this.pid.isValidPid())
    }

    /**
     * byr (Birth Year) - four digits; at least 1920 and at most 2002.
     */
    fun String.isValidByr(): Boolean = this.toIntOrNull() in 1920..2002

    /**
     * iyr (Issue Year) - four digits; at least 2010 and at most 2020.
     */
    fun String.isValidIyr(): Boolean = this.toIntOrNull() in 2010..2020

    /**
     * eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
     */
    fun String.isValidEyr(): Boolean = this.toIntOrNull() in 2020..2030

    /**
     * hgt (Height) - a number followed by either cm or in:
     * If cm, the number must be at least 150 and at most 193.
     * If in, the number must be at least 59 and at most 76.
     */
    fun String.isValidHgt(): Boolean {
        return if (this.endsWith("cm")) {
            this.substring(0, this.length - 2).toIntOrNull() in 150..193
        } else if (this.endsWith("in")) {
            this.substring(0, this.length - 2).toIntOrNull() in 59..76
        } else false
    }

    /**
     * hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
     */
    fun String.isValidHcl(): Boolean = """#[[0-9]|[a-f]]{6}""".toRegex() matches this

    /**
     * ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
     */
    fun String.isValidEcl(): Boolean = this in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    /**
     * pid (Passport ID) - a nine-digit number, including leading zeroes.
     */
    fun String.isValidPid(): Boolean = """[0-9]{9}""".toRegex() matches this

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

}

data class Passport(
    val byr: String, val iyr: String, val eyr: String, val hgt: String, val hcl: String, val ecl: String,
    val pid: String, val cid: String
)