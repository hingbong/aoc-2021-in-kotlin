fun main() {
    val input = readInput("Day01")
    run part01@{
        var counter = 0
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
    run part02@{
        var counter = 0
        val list = object : ArrayList<Int>(MAX_SIZE) {
            override fun add(element: Int): Boolean {
                if (size == MAX_SIZE) {
                    removeFirst()
                }
                return super.add(element)
            }
        }
        if (input.size < MAX_SIZE) {
            println(0)
            return
        }
        list.add(input[0].toInt())
        list.add(input[1].toInt())
        list.add(input[2].toInt())
        (MAX_SIZE until input.size)
            .forEach {
                val i = input[it].toInt()
                val previous = list.sum()
                list.add(i)
                if (previous < list.sum()) {
                    counter++
                }
            }
        println(counter)
    }
}

private const val MAX_SIZE = 3
