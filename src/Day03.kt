fun main() {
    val readInput = readInput("Day03")
    if (readInput.size < 2) return
    run part01@{
        val indices = readInput[0].indices
        val intList = indices.map { i ->
            readInput.groupingBy { it[i] }.eachCount()
        }
        val gammaRate = intList.joinToString("") {
            it.maxByOrNull { it.value }!!.key.toString()
        }
        val epsilonRate = gammaRate.map { if (it == '0') '1' else '0' }.joinToString("").toInt(2)
        println(gammaRate.toInt(2) * epsilonRate)
    }

    run part02@{
        val n = readInput[0].length
        val get = { oxygen: Boolean ->
            var rem = readInput
            var i = 0
            while (i < n && rem.size > 1) {
                var count0 = 0
                var count1 = 0
                for (line in rem) {
                    when (line[i]) {
                        '0' -> count0++
                        '1' -> count1++
                    }
                }
                val want = if (oxygen) {
                    if (count1 >= count0) '1' else '0'
                } else {
                    if (count0 <= count1) '0' else '1'
                }
                rem = rem.filter { line -> line[i] == want }
                i++
            }
            rem.first().toInt(2)
        }
        println(get(true) * get(false))
    }
}
