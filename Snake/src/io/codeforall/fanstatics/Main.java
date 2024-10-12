package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {
        int dimension = 400;
        Rectangle field = new Rectangle(0, 0, dimension, dimension);
        field.setColor(Color.BLACK);
        field.fill();

        Snake snake = new Snake(dimension-10);
    }
}
