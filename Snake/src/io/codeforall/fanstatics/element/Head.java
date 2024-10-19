package io.codeforall.fanstatics.element;

public enum Head {
    DOWN("Snake/rsc/head_down.png"),
    LEFT("Snake/rsc/head_left.png"),
    RIGHT("Snake/rsc/head_right.png"),
    UP("Snake/rsc/head_up.png");

    private String path;

    Head(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
