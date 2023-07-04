package next.step.minesweeper.domain.board.state

sealed class BoardPointState {
    abstract fun notifyMine(): BoardPointState

    abstract fun uncover(): BoardPointState

    abstract fun isMine(): Boolean
}
