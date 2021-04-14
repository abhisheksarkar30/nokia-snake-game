package edu.abhi.games.nokiasnake.console;

// To represent a cell of display board.
public class Cell {

    private final int row, col;
    private CellType cellType;

    private Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellType = CellType.EMPTY;
    }

    public final static Cell[][] initBoardCells(int ROW_COUNT, int COL_COUNT) {
        Cell[][] cells = new Cell[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COL_COUNT; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
        return cells;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
