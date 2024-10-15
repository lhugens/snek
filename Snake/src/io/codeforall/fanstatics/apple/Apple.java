package io.codeforall.fanstatics.apple;

import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGridPosition;
import io.codeforall.fanstatics.grid.GridColor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Apple {
    private SimpleGfxGrid grid;
    public SimpleGfxGridPosition pos;

    public Apple(SimpleGfxGrid grid, SimpleGfxGridPosition pos) {
        this.grid = grid;
        this.pos = pos;

        this.pos.setColor(GridColor.RED);
    }

    public void delete(){
        this.pos.hide();
    }

}
