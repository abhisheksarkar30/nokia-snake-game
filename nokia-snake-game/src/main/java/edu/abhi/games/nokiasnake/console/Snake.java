package edu.abhi.games.nokiasnake.console;

// To represent a snake

import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    private Deque<Cell> snakePartList = new ArrayDeque<>();

    public Snake(Cell initPos) { moveHead(initPos); }

    private void moveHead(Cell nextCell) {
        snakePartList.addFirst(nextCell);
        nextCell.setCellType(CellType.SNAKE_NODE);
    }

    public void grow(Cell nextCell) {
        moveHead(nextCell);
//        System.out.println("Snake is growing to size = " + snakePartList.size());
    }

    public void move(Cell nextCell) {
//        System.out.println("Snake is moving to " + nextCell.getRow() + " " + nextCell.getCol());
        Cell tail = snakePartList.removeLast();
        tail.setCellType(CellType.EMPTY);

        moveHead(nextCell);
    }

    public boolean checkCrash(Cell nextCell) {
//        System.out.println("Going to check for Crash");
//        return getHead() == nextCell || snakePartList.stream().anyMatch(cell -> cell == nextCell);
        return (getHead() == nextCell) || (nextCell.getCellType() == CellType.SNAKE_NODE);
    }

    public Deque<Cell> getSnakePartList() {
        return snakePartList;
    }

    public void setSnakePartList(Deque<Cell> snakePartList) {
        this.snakePartList = snakePartList;
    }

    public Cell getHead() { return snakePartList.getFirst(); }
}
