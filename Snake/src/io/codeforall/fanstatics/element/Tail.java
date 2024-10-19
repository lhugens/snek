package io.codeforall.fanstatics.element;

public enum Tail {
    DOWN("Snake/rsc/tail_down.png"),
    LEFT("Snake/rsc/tail_left.png"),
    RIGHT("Snake/rsc/tail_right.png"),
    UP("Snake/rsc/tail_up.png");

    private String path;

    Tail(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
