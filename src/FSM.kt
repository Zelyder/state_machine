class FSM(
    private val alphabet: Set<Char>,
    private val states: Set<String>,
    var startState: String,
    private val finishStates: List<String>,
    private val transitions: Map<String, Map<Char, String>>
) {
    private var currentState = startState

    private fun changeState(symbol: Char){
        currentState = transitions[currentState]?.get(symbol) ?: throw Error("Нет перехода из $currentState по $symbol")
    }

    private fun checkBelongAlphabet(symbol: Char):Boolean {
        if (symbol in alphabet){
            return true
        } else {
            throw Error("Неизвестный символ $symbol")
        }
    }

    fun isDeterminate(){

    }


    fun test(input: String): Boolean{
        currentState = startState
        for (symbol in input){
            checkBelongAlphabet(symbol)
            changeState(symbol)
        }
        return finishStates.contains(currentState)
    }

}