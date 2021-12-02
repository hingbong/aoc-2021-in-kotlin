fun main() {
    val input = readInput("Day02")
    run part01@{
        var (x, y) = 0 to 0
        input.forEach {
            val split = it.split(" ")
            val command = split[0]
            val unit = split[1].toInt()
            when (command) {
                "forward" -> x += unit
                "down" -> y += unit
                "up" -> y -= unit
            }
        }
        println(x * y)
    }
    run part02@{
        var (x, y, aim) = Triple(0, 0, 0)
        input.forEach {
            val split = it.split(" ")
            val command = split[0]
            val unit = split[1].toInt()
            when (command) {
                "forward" -> {
                    x += unit
                    y += (aim * unit)
                }
                "down" -> aim += unit
                "up" -> aim -= unit
            }
        }
        println(x * y)
    }
}
