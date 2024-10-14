package io.codeforall.fanstatics;

import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.snake.Snake;
import io.codeforall.fanstatics.grid.*;
import io.codeforall.fanstatics.snake.SnakeFactory;

public class Game {
    private SimpleGfxGrid grid;
    private Snake snake;

    public Game(int cols, int rows) {
        this.grid = SimpleGfxGridFactory.makeGrid(cols, rows);
    }

    public void init(){
        this.grid.init();

        this.snake = SnakeFactory.getNewSnake(this.grid);
    }

}
