package io.codeforall.fanstatics.snake;

import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;

public class SnakeFactory {

    public static Snake getNewSnake(SimpleGfxGrid grid){
        Snake snake = null;
        try {
            snake = new Snake(grid, grid.makeGridPosition());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return snake;
    }
}
