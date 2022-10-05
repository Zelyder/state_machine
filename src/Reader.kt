import java.io.File

object Reader {

    fun readFile(fileName: String): MutableList<Edge> {
        val edges: MutableList<Edge> = mutableListOf()
        File(fileName).forEachLine {
            val from = it.substringBefore(',')
            val to = it.substringAfterLast('=')
            val data: Char = it.substringAfter(',')[0]
            edges.add(Edge(from, to, data))
        }
        return edges
    }


}