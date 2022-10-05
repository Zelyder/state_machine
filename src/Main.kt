fun main() {
    run("var3_nd.txt")
}

fun run(fileName: String) {
    val edges = Reader.readFile("assets/$fileName")
    for (item in edges) {
        println(item)
    }
    println("Детерминированный: ${isDeterminate(edges)}")

    val transitions = edgesToMap(edges)
    val alphabet = extractAlphabet(edges)
    val finishStates = extractFinishStates(edges)
    val startState = "q0"

    println("transitions: $transitions")
    println("alphabet: $alphabet")
    println("finishStates: $finishStates")

    val fsm = FSM(
        alphabet, transitions.keys, startState, finishStates,
        transitions
    )
    while (true) {
        try {
            println("Введите сроку:")
            val input = readLine() ?: "" // for example: for (int abc = 0; abc < 954; abc++)
            if (fsm.test(input)) {
                println("Строка успешно разобрана!")
            } else {
                println("Ошибка!")
            }
        } catch (ex: Error) {
            println("Ошибка!")
            println(ex.message)
        }

    }

}