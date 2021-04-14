package edu.abhi.games.nokiasnake.console;

import java.io.IOException;
import java.util.Scanner;

// To represent Snake Game
public class Game {

    private Snake snake;
    private Board board;
    private Direction direction;
    private boolean gameOver;

    public Game(Board board) {
        this.board = board;

        initGame();
    }

    private void initGame() {
        Cell initPos = board.getCells()[0][0];
        this.snake = new Snake(initPos);
        this.gameOver = false;
        this.direction = Direction.NONE;
        board.generateFood();
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        if(Math.abs(this.direction.getIntCode()) == Math.abs(direction.getIntCode())) {
            System.out.println("Snake not allowed to trace back!");
        } else
            this.direction = direction;
    }

    // We need to update the game at regular intervals,
    // and accept user input from the Keyboard.
    public void update() {
        if (!gameOver) {
            if (direction != Direction.NONE) {
                System.out.println("Going to update the game");
                Cell nextCell = getNextCell(snake.getHead());

                if (snake.checkCrash(nextCell)) {
                    setDirection(Direction.NONE);
                    gameOver = true;
                    System.out.println("Crashed! Game Over!!!");
                    System.exit(0);
                } else {
                    if (nextCell.getCellType() == CellType.FOOD) {
                        snake.grow(nextCell);
                        board.generateFood();
                    } else if (nextCell.getCellType() == CellType.EMPTY){
                        snake.move(nextCell);
                    }
                }
            }
        }
    }

    private Cell getNextCell(Cell currentPosition) {
        System.out.println("Going to find next cell");
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();

        switch(direction) {
            case RIGHT: col++; break;
            case LEFT: col--; break;
            case UP: row--; break;
            case DOWN: row++; break;
        }

        try {
            return board.getCells()[row][col];
        } catch(ArrayIndexOutOfBoundsException e) {
            return currentPosition;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Going to start game");

        Game newGame = new Game(new Board(4, 4));

        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                Thread.sleep(3000);

                if (System.in.available() != 0) {
                    Direction direction = Direction.getDirectionByCharCode(sc.next());
                    if(direction != Direction.NONE)
                        newGame.setDirection(direction);
                    else {
                        System.out.println("Invalid Direction provided!!!");
                    }
                }

                newGame.update();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
