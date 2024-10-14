package io.codeforall.fanstatics.snake;

import io.codeforall.fanstatics.grid.Grid;

public class SnakeFactory {

    public static Snake getNewSnake(Grid grid){
        Snake snake = null;
        try {
            snake = new Snake(grid.makeGridPosition());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return snake;
    }
}
