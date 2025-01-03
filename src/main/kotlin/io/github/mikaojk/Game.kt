package io.github.mikaojk


class Game(private var snake: Snake, var board: Board) {

    companion object {
        const val DIRECTION_NONE = 0
        const val DIRECTION_RIGHT = 1
        const val DIRECTION_LEFT = -1
        const val DIRECTION_UP = 2
        const val DIRECTION_DOWN = -2
    }

    var direction: Int = 0
    var gameOver: Boolean = false

    fun update() {
        println("Going to update the game")
        if (!gameOver) {
            if (direction != DIRECTION_NONE) {
                val nextCell = getNextCell(snake.head)

                if (snake.checkCrash(nextCell)) {
                    direction = DIRECTION_NONE
                    gameOver = true
                } else {
                    snake.move(nextCell)
                    if (nextCell.cellType == CellType.FOOD) {
                        snake.grow()
                        board.generateFood()
                    }
                }
            }
        }
    }

    private fun getNextCell(currentPosition: Cell): Cell {
        println("Going to find next cell")
        var row = currentPosition.row
        var col = currentPosition.col

        when (direction) {
            DIRECTION_RIGHT -> col++
            DIRECTION_LEFT -> col--
            DIRECTION_UP -> row--
            DIRECTION_DOWN -> row++
        }

        return board.cells[row][col]
    }
}


