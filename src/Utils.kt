fun edgesToMap(edges: List<Edge>): Map<String, Map<Char, String>> {
    val map = mutableMapOf<String, MutableMap<Char, String>>()

    for (edge in edges){
        if (map.containsKey(edge.from)){
            map[edge.from]?.put(edge.data, edge.to)
        } else {
            map[edge.from] = mutableMapOf(edge.data to edge.to)
        }
    }
    return map
}

fun extractAlphabet(edges: List<Edge>): Set<Char>{
    val set = mutableSetOf<Char>()
    for (edge in edges) {
        set.add(edge.data)
    }
    return set
}

fun extractFinishStates(edges: List<Edge>): List<String> {
    val list = mutableListOf<String>()
    for (edge in edges) {
        if (edge.to[0] == 'f')
        list.add(edge.to)
    }
    return list
}

fun isDeterminate(edges: List<Edge>):Boolean{
    val map = mutableMapOf<String, MutableList<Char>>()
    for (edge in edges){
        if (map[edge.from]?.contains(edge.data) == true){
            return false
        } else {
            if (!map.containsKey(edge.from)){
                map[edge.from] = mutableListOf(edge.data)
            } else {
                map[edge.from]?.add(edge.data)
            }

        }
    }
    return true
}