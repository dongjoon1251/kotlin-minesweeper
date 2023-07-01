package next.step.minesweeper.controller

import next.step.blackjack.view.OutputView
import next.step.minesweeper.domain.board.Board
import next.step.minesweeper.domain.mine.generator.RandomMineGenerator
import next.step.minesweeper.view.InputView

fun main() {
    runCatching {
        val board = Board.covered(InputView.readHeight(), InputView.readWidth())
        board.plantMines(RandomMineGenerator.generate(board, InputView.readMineCnt()))
        OutputView.showBoard(board)
    }.onFailure { e ->
        OutputView.showError(e.message)
        main()
    }
}
