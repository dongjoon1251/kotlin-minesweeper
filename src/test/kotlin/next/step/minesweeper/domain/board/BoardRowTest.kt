package next.step.minesweeper.domain.board

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import next.step.minesweeper.domain.board.state.CoveredState
import next.step.minesweeper.domain.board.state.MineFreeState
import next.step.minesweeper.domain.board.state.MineState
import next.step.minesweeper.domain.board.state.NearMineState
import org.junit.jupiter.api.assertThrows

class BoardRowTest : DescribeSpec({

    describe("BoardRow") {
        context("지뢰 심으면") {
            it("특정 위치만 MineState로 바뀜") {
                val boardRow =
                    BoardRow(listOf(BoardPoint.mineFree(), BoardPoint.mineFree(), BoardPoint.mineFree()))

                boardRow.plantMine(1)

                boardRow.points() shouldBe listOf(
                    BoardPoint(CoveredState(MineFreeState)),
                    BoardPoint(CoveredState(MineState)),
                    BoardPoint(CoveredState(MineFreeState)),
                )
            }
        }

        context("지뢰 최대 너비 넘어가게 심으면") {
            it("예외 발생") {
                val boardRow =
                    BoardRow(listOf(BoardPoint.mineFree(), BoardPoint.mineFree(), BoardPoint.mineFree()))

                assertThrows<IllegalArgumentException> {
                    boardRow.plantMine(3)
                }.shouldHaveMessage("지뢰 x 위치는 3 보다 작아야 합니다.")
            }
        }

        context("can uncover") {
            it("uncover할 수 있는 Point가 있으면 true") {
                val boardRow =
                    BoardRow(
                        listOf(
                            BoardPoint(CoveredState(MineFreeState)),
                            BoardPoint(CoveredState(MineState)),
                            BoardPoint(MineFreeState),
                        ),
                    )

                boardRow.canUncover() shouldBe true
            }
            it("uncover할 수 있는 Point가 없으면 false") {
                val boardRow =
                    BoardRow(
                        listOf(
                            BoardPoint(MineFreeState),
                            BoardPoint(CoveredState(MineState)),
                            BoardPoint(MineFreeState),
                        ),
                    )

                boardRow.canUncover() shouldBe false
            }
        }

        context("uncover") {
            it("특정 위치를 열고 열린 Point를 제공") {
                val boardRow =
                    BoardRow(
                        listOf(
                            BoardPoint(MineFreeState),
                            BoardPoint(CoveredState(MineState)),
                            BoardPoint(MineFreeState),
                        ),
                    )

                val result = boardRow.uncover(1)

                result shouldBe BoardPoint(MineState)
            }
        }

        context("notifyMine") {
            it("특정 위치의 상태가 NearMineState가 됨") {
                val boardRow =
                    BoardRow(
                        listOf(
                            BoardPoint(CoveredState(MineFreeState)),
                            BoardPoint(CoveredState(MineState)),
                            BoardPoint(CoveredState(MineFreeState)),
                        ),
                    )

                boardRow.notifyMine(0)

                boardRow.points() shouldBe listOf(
                    BoardPoint(CoveredState(NearMineState.one())),
                    BoardPoint(CoveredState(MineState)),
                    BoardPoint(CoveredState(MineFreeState)),
                )
            }
        }

        context("is mine free") {
            it("지뢰 없으면 true") {
                val boardRow =
                    BoardRow(
                        listOf(
                            BoardPoint(CoveredState(MineFreeState)),
                            BoardPoint(CoveredState(MineState)),
                            BoardPoint(MineFreeState),
                        ),
                    )

                boardRow.isMineFree(2) shouldBe true
            }
            it("지뢰면 false") {
                val boardRow =
                    BoardRow(
                        listOf(
                            BoardPoint(MineFreeState),
                            BoardPoint(CoveredState(MineState)),
                            BoardPoint(MineFreeState),
                        ),
                    )

                boardRow.isMineFree(1) shouldBe false
            }
            it("주변에 지뢰가 있어도 false") {
                val boardRow =
                    BoardRow(
                        listOf(
                            BoardPoint(MineFreeState),
                            BoardPoint(CoveredState(MineState)),
                            BoardPoint(NearMineState.one()),
                        ),
                    )

                boardRow.isMineFree(1) shouldBe false
            }
        }
    }
})
