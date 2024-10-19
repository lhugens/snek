package io.codeforall.fanstatics.element;

public enum Tail {
    DOWN("rsc/tail_down.png"),
    LEFT("rsc/tail_left.png"),
    RIGHT("rsc/tail_right.png"),
    UP("rsc/tail_up.png");

    public String picturePath;

    Tail(String picturePath){
        this.picturePath = picturePath;
    }
}
