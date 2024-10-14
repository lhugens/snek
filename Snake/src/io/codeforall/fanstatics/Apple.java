package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Apple {
    private int xCoord;
    private int yCoord;
    private Rectangle rectangle;

    public Apple(int padding, int xLimit, int yLimit) {
        this.rectangle = new Rectangle(padding + (int) (Math.random() * xLimit), padding + (int) (Math.random() * yLimit), 10, 10);
        this.rectangle.setColor(Color.RED);
        this.rectangle.fill();
    }

}
