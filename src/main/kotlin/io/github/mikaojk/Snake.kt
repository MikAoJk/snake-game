package io.github.mikaojk

import java.util.LinkedList

class Snake(initPos: Cell) {

    private var snakePartList: LinkedList<Cell> = LinkedList()
    var head: Cell = initPos

    init {
        snakePartList.add(head)
        head.cellType = CellType.SNAKE_NODE
    }

    fun grow() {
        snakePartList.add(head)
    }

    fun move(nextCell: Cell) {
        println("Snake is moving to ${nextCell.row} ${nextCell.col}")
        val tail = snakePartList.removeLast()
        tail.cellType = CellType.EMPTY

        head = nextCell
        head.cellType = CellType.SNAKE_NODE
        snakePartList.addFirst(head)
    }

    fun checkCrash(nextCell: Cell): Boolean {
        println("Going to check for Crash")
        for (cell in snakePartList) {
            if (cell == nextCell) {
                return true
            }
        }
        return false
    }

}

