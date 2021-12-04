fun main() {
    fun getNumberOfBits(input: List<String>): Int {
        return input.fold(0) { bits: Int, element: String ->
            if (element.length > bits) element.length else bits
        }
    }

    fun part1(input: List<String>): Int {
        var gama = ""
        var epsilon = ""
        val nrOfBits = getNumberOfBits(input)
        for (i in 0 until nrOfBits) {
            val isBinary1 = input.filter { it[i] == '1' }.size > (input.size / 2)
            gama = if(isBinary1) gama + "1" else gama + "0"
            epsilon = if(isBinary1) epsilon + "0" else epsilon + "1"
        }
        return (Integer.parseInt(gama, 2) * Integer.parseInt(epsilon, 2))
    }

    fun getMostCommonByPosition(input: List<String>, position: Int): Char {
        val isBinary1 = input.filter { it[position] == '1' }.size * 2  >= input.size
        return if(isBinary1) '1' else '0'
    }

    fun getLeastCommonByPosition(input: List<String>, position: Int): Char {
        val isBinary1 = input.filter { it[position] == '1' }.size * 2 >= input.size
        return if(isBinary1) '0' else '1'
    }

    fun getO2Number(input: List<String>, position: Int): List<String> {
        if(input.size == 1) return input
        val mostCommon = getMostCommonByPosition(input, position)
        val acceptedElements = input.filter { it[position] == mostCommon }
        if(acceptedElements.size == input.size) return listOf(acceptedElements[0])
        return getO2Number(acceptedElements, position + 1)
    }

    fun getCO2Number(input: List<String>, position: Int): List<String> {
        if(input.size == 1) return input
        val leastCommon = getLeastCommonByPosition(input, position)
        val acceptedElements = input.filter { it[position] == leastCommon }
        if(acceptedElements.size == input.size) return listOf(acceptedElements[0])
        return getCO2Number(acceptedElements, position + 1)
    }

    fun part2(input: List<String>): Int {
        val O2 = getO2Number(input, 0)[0]
        val CO2 = getCO2Number(input, 0)[0]
        return (Integer.parseInt(O2, 2) * Integer.parseInt(CO2, 2))
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
