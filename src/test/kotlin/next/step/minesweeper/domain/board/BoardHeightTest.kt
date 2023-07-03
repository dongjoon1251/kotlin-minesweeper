package next.step.minesweeper.domain.board

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.assertThrows

class BoardHeightTest : DescribeSpec({

    describe("BoardHeight") {
        context("0이하의 값으로 생성하면 예외 발생") {
            withData(
                listOf(-1, 0),
            ) { height ->
                assertThrows<IllegalArgumentException> { BoardHeight(height) }
            }
        }
        context("Position의 y가 범위에 없으면, 예외발생") {
            withData(
                listOf(10, -1),
            ) { y ->
                assertThrows<IllegalArgumentException> {
                    BoardHeight(10).requireInRange(y)
                }.shouldHaveMessage("y 위치는 0보다 크고, 10 보다 작아야 합니다.")
            }
        }
        context("Position의 y가 범위에 없으면, false") {
            withData(
                listOf(10, -1),
            ) { y ->
                BoardHeight(10).inRange(y) shouldBe false
            }
        }
        context("Position의 y가 범위에 있으면, true") {
            withData(
                listOf(0, 9),
            ) { x ->
                BoardHeight(10).inRange(x) shouldBe true
            }
        }
        context("method") {
            val height = BoardHeight(10)
            it("height 제공") {
                height.height() shouldBe 10
            }
            it("rangeMap으로 변환 제공") {
                height.rangeMap { it + 3 } shouldBe listOf(3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
            }
        }
    }
})
