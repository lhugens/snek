package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import io.codeforall.fanstatics.grid.*;

public class Game {
    private Grid grid;

    public Game(int cols, int rows) {
        this.grid = GridFactory.makeGrid(cols, rows);
    }

    public void init(){
        this.grid.init();
    }

}
