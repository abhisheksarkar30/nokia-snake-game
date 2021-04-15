package edu.abhi.games.nokiasnake.console;

import java.util.Arrays;

// Enum for different cell types
enum CellType {
    EMPTY(" "), //Unoccupied Cell
    FOOD("@"), //Current position of the Egg/Snake-food
    SNAKE_NODE("*"); //Nodes currently occupied by the Snake

    private String displayCode;

    CellType(String displayCode) {
        this.displayCode = displayCode;
    }

    public String getDisplayCode() {
        return displayCode;
    }
}

enum Direction {
    NONE("N", 0),
    RIGHT("R", 1),
    LEFT("L", -1),
    UP("U", 2),
    DOWN("D", -2);

//    public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1,
//            DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;

    private String charCode;
    private int intCode;

    public String getCharCode() {
        return charCode;
    }

    public int getIntCode() {
        return intCode;
    }

    Direction(String charCode, int intCode) {
        this.charCode = charCode;
        this.intCode = intCode;
    }

    public static Direction getDirectionByCharCode(String charCode) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getCharCode().equalsIgnoreCase(charCode))
                .findFirst()
                .orElse(Direction.NONE);
    }
}


