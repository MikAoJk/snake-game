package io.github.mikaojk

class Board(private val rowCount: Int, private val colCount: Int) {

    var cells: Array<Array<Cell>> = Array(rowCount) { Array(colCount) { Cell(0, 0) } }

    init {
        for (row in 0 until rowCount) {
            for (column in 0 until colCount) {
                cells[row][column] = Cell(row, column)
            }
        }
    }

    fun generateFood() {
        println("Going to generate food")
        var row: Int
        var column: Int
        while (true) {
            row = (0 until rowCount).random()
            column = (0 until colCount).random()
            if (cells[row][column].cellType != CellType.SNAKE_NODE) break
        }
        cells[row][column].cellType = CellType.FOOD
        println("Food is generated at: $row $column")
    }
}

enum class CellType {
    EMPTY,
    FOOD,
    SNAKE_NODE
}


