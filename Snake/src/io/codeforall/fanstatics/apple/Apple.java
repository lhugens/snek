package io.codeforall.fanstatics.apple;

import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.gfx.simplegfx.Picture;
import io.codeforall.fanstatics.grid.GridColor;

public class Apple {
    private SimpleGfxGrid grid;
    public Picture pos;

    public Apple(SimpleGfxGrid grid, Picture pos) {
        this.grid = grid;
        this.pos = pos;

        this.pos.setColor(GridColor.RED);
    }

    public void delete(){
        this.pos.hide();
    }

}
