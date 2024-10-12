package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;

public class Snake implements KeyboardHandler {
    private Rectangle head;
    private int cellSize;
    private Rectangle[] body;
    private int size;
    private int[] headCoords;
    private int[] oldCoords;
    private int speed;
    public Keyboard keyboard;
    private Direction direction;

    public Snake() {
        this.speed = 5;
        this.size = 10;
        this.cellSize = 10;
        this.body = new Rectangle[this.size];
        this.direction = Direction.UP;

        this.headCoords = new int[2];
        this.headCoords[0] = (int) (Math.random() * 200);
        this.headCoords[1] = (int) (Math.random() * 200);
        this.oldCoords = new int[2];
        this.oldCoords[0] = this.headCoords[0];
        this.oldCoords[1] = this.headCoords[1];

        this.head = new Rectangle(this.headCoords[0], this.headCoords[1], this.cellSize, this.cellSize);
        this.head.setColor(Color.GREEN);
        this.head.fill();

        this.body[0] = this.head;

        for (int i = 1; i < size; i++) {
            this.body[i] = new Rectangle(this.headCoords[0], this.headCoords[1] - this.cellSize * i, this.cellSize, this.cellSize);
            this.body[i].setColor(Color.GREEN);
            this.body[i].fill();
        }

        initKeyboard();
    }

    public void moveBody(int[] oldCoords) {
        int[] previous = new int[2];
        previous[0] = oldCoords[0];
        previous[1] = oldCoords[1];

        for (int i = 1; i < this.body.length; i++) {
            int[] temp = new int[2];
            temp[0] = this.body[i].getX();
            temp[1] = this.body[i].getY();

            this.body[i].translate(previous[0] - temp[0], previous[1] - temp[1]);

            previous[0] = temp[0];
            previous[1] = temp[1];
        }
    }


    private void initKeyboard() {
        this.keyboard = new Keyboard(this);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.keyboard.addEventListener(moveLeft);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.keyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.keyboard.addEventListener(moveDown);
    }

    public void move(Direction direction){
        this.oldCoords[0] = this.headCoords[0];
        this.oldCoords[1] = this.headCoords[1];
        switch (direction){
            case RIGHT:
                if(this.direction != Direction.LEFT) {
                    this.head.translate(this.speed, 0);
                    headCoords[0] += this.speed;
                    this.direction = Direction.RIGHT;
                    this.moveBody(this.oldCoords);
                } else {
                    move(this.direction);
                }
                break;
            case LEFT:
                if(this.direction != Direction.RIGHT){
                    this.head.translate(-this.speed, 0);
                    headCoords[0] -= this.speed;
                    this.direction = Direction.LEFT;
                    this.moveBody(this.oldCoords);
                } else {
                    move(this.direction);
                }
                break;
            case UP:
                if(this.direction != Direction.DOWN){
                    this.head.translate(0, -this.speed);
                    headCoords[1] -= this.speed;
                    this.direction = Direction.UP;
                    this.moveBody(this.oldCoords);
                } else {
                    move(this.direction);
                }
                break;
            case DOWN:
                if(this.direction != Direction.UP){
                    this.head.translate(0, this.speed);
                    headCoords[1] += this.speed;
                    this.direction = Direction.DOWN;
                    this.moveBody(this.oldCoords);
                } else {
                    move(this.direction);
                }
                break;
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                move(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                move(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_UP:
                move(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                move(Direction.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
