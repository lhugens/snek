package io.codeforall.fanstatics;

import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.grid.SimpleGfxGridFactory;
import io.codeforall.fanstatics.snake.Snake;
import io.codeforall.fanstatics.snake.SnakeFactory;

public class Game {
    private int cols;
    private int rows;
    private SimpleGfxGrid grid;

    private Snake snake;

    public Game(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        this.grid = SimpleGfxGridFactory.makeGrid(cols, rows);
        this.grid.init();
    }

    public void init(){
        this.snake = SnakeFactory.getNewSnake(this.grid);

    }
}
