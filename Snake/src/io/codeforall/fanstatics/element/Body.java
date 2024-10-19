package io.codeforall.fanstatics.element;

public enum Body {
    BOTTOM_LEFT("Snake/rsc/body_bl.png"),
    BOTTOM_RIGHT("Snake/rsc/body_br.png"),
    HORIZONTAL("Snake/rsc/body_horizontal.png"),
    TOP_LEFT("Snake/rsc/body_tl.png"),
    TOP_RIGHT("Snake/rsc/body_tr.png"),
    VERTICAL("Snake/rsc/body_vertical.png");

    private String path;

    Body(String paht){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
