class Counter (
    var horizontal: Int,
    var vertical: Int,
    var aim: Int
)

fun main() {
    fun part1(input: List<String>): Int {
        val counter = Counter(0, 0, 0)
        input.forEach { element ->
            val parts = element.split(" ")
            when(parts[0]) {
                "forward" -> counter.horizontal += parts[1].toInt()
                "down" -> counter.vertical += parts[1].toInt()
                "up" -> counter.vertical -= parts[1].toInt()
            }
        }
        return counter.horizontal * counter.vertical
    }

    fun part2(input: List<String>): Int {
        val counter = Counter(0, 0, 0)
        input.forEach { element ->
            val parts = element.split(" ")
            when(parts[0]) {
                "forward" -> {
                    counter.horizontal += parts[1].toInt()
                    counter.vertical += (counter.aim * parts[1].toInt())
                }
                "down" -> counter.aim += parts[1].toInt()
                "up" -> {
                    counter.aim -= parts[1].toInt()
                    if (counter.aim < 0) counter.aim = 0
                }
            }
        }
        return counter.horizontal * counter.vertical
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}