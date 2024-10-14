package io.codeforall.fanstatics.snake;

import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGridPosition;
import io.codeforall.fanstatics.grid.Grid;
import io.codeforall.fanstatics.grid.GridColor;
import io.codeforall.fanstatics.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;
import java.security.Key;

public class Snake implements KeyboardHandler {
    public Keyboard keyboard;
    private GridPosition pos;
    private SimpleGfxGrid grid;
    private int length;
    private GridPosition[] body;

    public Snake(SimpleGfxGrid grid, GridPosition pos) throws InterruptedException {
        this.grid = grid;
        initKeyboard();

        this.length = 3;

        this.pos = pos;
        pos.setColor(GridColor.GREEN);

        this.body = new SimpleGfxGridPosition[this.length];

        for (int i = 0; i < this.length; i++) {
            body[i] = this.grid.makeGridPosition(this.pos.getCol(), this.pos.getRow()-i);
            body[i].setColor(GridColor.GREEN);
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

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                break;
            case KeyboardEvent.KEY_LEFT:
                break;
            case KeyboardEvent.KEY_UP:
                break;
            case KeyboardEvent.KEY_DOWN:
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
