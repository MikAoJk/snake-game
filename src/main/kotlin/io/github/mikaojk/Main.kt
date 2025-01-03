package io.github.mikaojk

import io.github.mikaojk.Game.Companion.DIRECTION_RIGHT

fun main() {
    println("Going to start game")

    val snake = Snake(Cell(0, 0))
    val board = Board(10, 10)
    val game = Game(snake, board)

    game.direction = DIRECTION_RIGHT

    for (i in 0 until 9) {
        if (i == 2) game.board.generateFood()
        game.update()
        if (i == 3) game.direction = DIRECTION_RIGHT
        if (game.gameOver) {
            println("Game over!")
            break
        }
    }
}