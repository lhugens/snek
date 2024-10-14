package io.codeforall.fanstatics;

import io.codeforall.fanstatics.snake.Snake;
import io.codeforall.fanstatics.grid.*;
import io.codeforall.fanstatics.snake.SnakeFactory;

public class Game {
    private Grid grid;
    private Snake snake;

    public Game(int cols, int rows) {
        this.grid = GridFactory.makeGrid(cols, rows);
    }

    public void init(){
        this.grid.init();

        this.snake = SnakeFactory.getNewSnake(this.grid);
    }

}
