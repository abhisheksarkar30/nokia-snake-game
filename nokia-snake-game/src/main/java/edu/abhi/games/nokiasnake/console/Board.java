package edu.abhi.games.nokiasnake.console;

public class Board {

    final int ROW_COUNT, COL_COUNT;
    private Cell[][] cells;

    public Board(int rowCount, int columnCount) {
        ROW_COUNT = rowCount;
        COL_COUNT = columnCount;

        initBoard();
    }

    private void initBoard() {
        cells = Cell.initBoardCells(ROW_COUNT, COL_COUNT);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void generateFood() {
//        System.out.println("Going to generate food");
        while(true){
            int row = (int)(Math.random() * ROW_COUNT);
            int column = (int)(Math.random() * COL_COUNT);
            if(cells[row][column].getCellType() == CellType.EMPTY) {
                cells[row][column].setCellType(CellType.FOOD);
//                System.out.println("Food is generated at: " + row + " " + column);
                break;
            }
        }
    }

}
