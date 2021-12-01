fun main() {
    var counter = 0
    val input = readInput("Day01")
    if (input.size < 2) {
        println(0)
        return
    }
    var previous = input[0].toInt()
    (1 until input.size)
        .map { input[it] }
        .forEach {
            val i = it.toInt()
            if (i > previous) {
                counter++
            }
            previous = i
        }
    println(counter)
}
