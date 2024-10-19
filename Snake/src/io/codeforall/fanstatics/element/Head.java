package io.codeforall.fanstatics.element;

public enum Head {
    DOWN("rsc/head_down.png"),
    RIGHT("rsc/head_right.png"),
    UP("rsc/head_up.png"),
    LEFT("rsc/head_left.png");

    public String picturePath;

    Head(String picuturePath){
        this.picturePath = picuturePath;
    }
}
