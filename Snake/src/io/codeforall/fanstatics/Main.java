package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {
        int dimension = 400;
        Rectangle field = new Rectangle(0, 0, dimension, dimension);
        field.setColor(Color.BLACK);
        field.fill();

        try {
            Snake snake = new Snake(dimension-10);
        } catch (InterruptedException ex){
            System.out.println("Ooohhh.....");
        }
    }
}
