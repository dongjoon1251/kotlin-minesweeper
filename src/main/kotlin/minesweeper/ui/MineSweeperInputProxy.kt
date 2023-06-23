package minesweeper.ui

class MineSweeperInputProxy(private val target: MineSweeperInput) : MineSweeperInput {

    override fun requestWidth(): Int {
        val width = target.requestWidth()

        return if(width > 0) {
            width
        } else {
            println("너비는 0 이상의 자연수를 입력해주세요 [Input: $width]")
            requestWidth()
        }
    }

    override fun requestHeight(): Int {
        val height = target.requestWidth()

        return if(height > 0) {
            height
        } else {
            println("높이는 0 이상의 자연수를 입력해주세요 [Input: $height]")
            requestHeight()
        }
    }

    override fun requestMineCapacity(): Int {
        val mineCapacity = target.requestMineCapacity()

        return if(mineCapacity > 0) {
            mineCapacity
        } else {
            println("지뢰의 갯수는 0 이상의 자연수를 입력해주세요 [Input: $mineCapacity]")
            requestMineCapacity()
        }
    }
}
