fun main() {
    fun part1(input: List<String>): Int {
        return input.foldIndexed(0) { index, counter, element ->
            if (index > 0 && (element.toInt() > input[index - 1].toInt())) {
                counter + 1
            } else counter
        }
    }

    fun part2(input: List<String>): Int {
        return input.foldIndexed(0) { index, counter, element ->
            if(index >= input.size - 3) return@foldIndexed counter
            val sum1 = element.toInt() + input[index + 1].toInt() + input[index + 2].toInt()
            val sum2 = input[index + 1].toInt() + input[index + 2].toInt() + input[index + 3].toInt()
            if (sum2 > sum1) {
                counter + 1
            } else counter
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("resources/Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("resources/Day01")
    println(part1(input))
    println(part2(input))
}
