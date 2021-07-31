import aoc2020.Day1

fun main(args: Array<String>) {
    println("Hello World!")
    val day1 = Day1()
    val day1Input = day1.loadInput("input/day1.txt")
    val multipleOfTwo = day1.findMultipleOfTwoNumbersThatAddUpTo2020(day1Input)
    val multipleOfThree = day1.findMultipleOfThreeNumbersThatAddUpTo2020(day1Input)
    println("multiple of two: $multipleOfTwo")
    println("multiple of three: $multipleOfThree")
}