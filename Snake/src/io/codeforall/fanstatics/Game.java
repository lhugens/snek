package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {
    private Rectangle rectangle;
    private Rectangle field;
    private int border;
    public int PADDING;
    private int size;
    private Snake snake;
    private Apple apple;

    public Game(int size) {
        this.PADDING = 10;
        this.size = size;
        this.border = 20;
    }

    public void init(){
        this.rectangle = new Rectangle(this.PADDING, this.PADDING, this.size, this.size);
        this.rectangle.setColor(Color.GRAY);
        this.rectangle.fill();

        this.field = new Rectangle(this.PADDING + this.border, this.PADDING + this.border, this.size - 2*this.border, this.size - 2*this.border);
        this.field.setColor(Color.BLACK);
        this.field.fill();

        this.apple = new Apple(this.PADDING + this.border, this.size, this.size);

        try {
            this.snake = new Snake(this.PADDING + this.border, this.size - this.border);
        } catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }

    }
}
