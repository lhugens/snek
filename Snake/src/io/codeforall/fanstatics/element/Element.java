package io.codeforall.fanstatics.element;

import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Element {
    public SimpleGfxGridPosition pos;
    private ElementType type;
    public Picture picture;

    public Element(SimpleGfxGridPosition pos, String picturePath) {
        this.pos = pos;
        this.type = type;
        this.picture = new Picture(this.pos.getCol(), this.pos.getRow(), picturePath);
        this.picture.draw();
    }
}