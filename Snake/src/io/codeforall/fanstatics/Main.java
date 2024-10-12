package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle field = new Rectangle(0, 0, 400, 400);
        field.setColor(Color.BLACK);
        field.fill();

        Snake snake = new Snake();
    }
}
