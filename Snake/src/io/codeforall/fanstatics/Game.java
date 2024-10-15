package io.codeforall.fanstatics;

import io.codeforall.fanstatics.apple.AppleFactory;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.snake.Snake;
import io.codeforall.fanstatics.apple.Apple;
import io.codeforall.fanstatics.grid.*;
import io.codeforall.fanstatics.snake.SnakeFactory;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Game {
    private SimpleGfxGrid grid;
    private Snake snake;
    private Apple apple;

    public Game(int cols, int rows) {
        this.grid = SimpleGfxGridFactory.makeGrid(cols, rows);
    }

    public void init(){
        this.grid.init();
        this.snake = SnakeFactory.getNewSnake(this.grid);
        this.apple = AppleFactory.getNewApple(this.grid, this.snake);
        this.snake.addApple(this.apple);
        try {
            this.snake.run();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
