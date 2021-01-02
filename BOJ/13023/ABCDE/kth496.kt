fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val friends: Array<ArrayList<Int>> = Array(N + 1) { ArrayList() }
    val visited: Array<Boolean> = Array(N + 1) { false }

    for (i in 1..M) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        friends[a].add(b)
        friends[b].add(a)
    }

    fun find(cur: Int, cnt: Int): Boolean {
        visited[cur] = true
        var ret = false
        if (cnt == 5) return true
        for (next in friends[cur]) {
            if (!visited[next]) ret = ret || find(next, cnt + 1)
        }
        visited[cur] = false
        return ret
    }

    for (i in 1..N) {
        if (find(i, 1))  {
            println(1)
            return
        }
    }
    println(0)
}