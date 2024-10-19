package io.codeforall.fanstatics.element;

public enum Body {
    BOTTOM_LEFT("rsc/body_bl.png"),
    BOTTOM_RIGHT("rsc/body_br.png"),
    HORIZONTAL("rsc/body_horizontal.png"),
    VERTICAL("rsc/body_vertical.png"),
    TOP_LEFT("rsc/body_tl.png"),
    TOP_RIGHT("rsc/body_tr.png");

    public String picturePath;

    Body(String picturePath){
        this.picturePath = picturePath;
    }
}
