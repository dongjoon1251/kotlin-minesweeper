package next.step.minesweeper.view

import next.step.minesweeper.domain.board.BoardPoint
import next.step.minesweeper.domain.board.state.CoveredState
import next.step.minesweeper.domain.board.state.MineFreeState
import next.step.minesweeper.domain.board.state.MineState
import next.step.minesweeper.domain.board.state.NearMineState

object OutputView {

    private const val UNKNOWN_ERR_MSG = "알 수 없는 에러가 발생했습니다."
    private const val BOARD_TITLE = "지뢰찾기 게임 시작"
    private const val SUCCESS_MSG = "Win Game."
    private const val FAIL_MSG = "Lose Game."

    fun showTitle() {
        println()
        println(BOARD_TITLE)
    }

    fun showBoardPoints(boardPoints: List<List<BoardPoint>>) {
        boardPoints.forEach { printBoardRow(it) }
    }

    private fun printBoardRow(it: List<BoardPoint>) = println(desc(it).joinToString(" "))

    private fun desc(boardPoints: List<BoardPoint>): List<String> = boardPoints.map { desc(it) }

    private fun desc(boardPoint: BoardPoint): String =
        when (val state = boardPoint.state()) {
            is CoveredState -> "C"
            MineState -> "*"
            MineFreeState -> "0"
            is NearMineState -> state.count().toString()
        }

    fun showError(msg: String?) {
        println(msg ?: UNKNOWN_ERR_MSG)
        println()
    }

    fun showWin() {
        println(SUCCESS_MSG)
        println()
    }

    fun showLose() {
        println(FAIL_MSG)
        println()
    }
}
