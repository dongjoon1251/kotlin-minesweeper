package next.step.minesweeper.domain.mine.generator

import next.step.minesweeper.domain.board.BoardArea
import next.step.minesweeper.domain.mine.MineCount
import next.step.minesweeper.domain.position.Positions

interface MineGenerator {

    fun generate(area: BoardArea, count: MineCount): Positions
}
