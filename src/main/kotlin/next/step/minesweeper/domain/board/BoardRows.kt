package next.step.minesweeper.domain.board

@JvmInline
value class BoardRows(private val rows: List<BoardRow>) {

    fun plantMine(position: BoardPosition) = row(position.y()).plantMine(position.x())

    private fun row(y: Int) = rows[y]

    fun notifyMine(position: BoardPosition) = position.near().forEach { row(it.y()).pointAt(it.x()).notifyMine() }

    fun canUncover(): Boolean = rows.any { it.canUncover() }

    fun uncover(position: BoardPosition): Boolean {
        val point = row(position.y()).uncover(position.x())
        if (row(position.y()).pointAt(position.x()).isMineFree()) {
            val queue = position.near().toMutableList()
            uncover(queue, mutableSetOf(position))
        }
        return point.isMine()
    }

    private tailrec fun uncover(queue: MutableList<BoardPosition>, visited: MutableSet<BoardPosition>) {
        if (queue.isEmpty()) return
        val position = queue.removeAt(0)
        visited.add(position)
        val point = row(position.y()).pointAt(position.x())
        point.uncoverIfPossible()
        if (point.isMineFree()) {
            val nearPoints = position.near().filterNot { it in visited }
            queue.addAll(nearPoints)
            visited.addAll(nearPoints)
        }
        uncover(queue, visited)
    }

    fun points(): List<List<BoardPoint>> = rows.map { it.points() }
}
