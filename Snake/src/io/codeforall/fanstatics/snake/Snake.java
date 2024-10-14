package io.codeforall.fanstatics.snake;

import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGridPosition;
import io.codeforall.fanstatics.grid.GridColor;
import io.codeforall.fanstatics.grid.GridDirection;
import io.codeforall.fanstatics.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Snake implements KeyboardHandler {
    public Keyboard keyboard;
    private SimpleGfxGridPosition pos;
    private SimpleGfxGrid grid;
    private int length;
    private SimpleGfxGridPosition[] body;

    public Snake(SimpleGfxGrid grid, SimpleGfxGridPosition pos) throws InterruptedException {
        this.grid = grid;
        initKeyboard();

        this.length = 3;

        this.pos = pos;
        this.pos.lastDirection = GridDirection.DOWN;
        pos.setColor(GridColor.GREEN);

        this.body = new SimpleGfxGridPosition[this.length];

        for (int i = 0; i < this.length; i++) {
            body[i] = (SimpleGfxGridPosition) this.grid.makeGridPosition(this.pos.getCol(), this.pos.getRow()-i-1);
            body[i].setColor(GridColor.GREEN);
            body[i].lastDirection = GridDirection.DOWN;
        }
    }

    public void move(GridDirection direction) {
        // Store the current position and direction of the head before moving
        GridDirection prevDir = this.pos.lastDirection;
        this.pos.moveInDirection(direction, 1);
        this.pos.lastDirection = direction;

        // Store the previous direction of the first body part (to follow the head)
        GridDirection prevBodyDir = this.body[0].lastDirection;

        // Move the first body part to follow the head's previous position
        this.body[0].moveInDirection(prevDir, 1);
        this.body[0].lastDirection = prevDir;

        // Move the rest of the body parts to follow the one in front of them
        for (int i = 1; i < this.body.length; i++) {
            GridDirection tempDir = this.body[i].lastDirection;  // Store the current direction
            this.body[i].moveInDirection(prevBodyDir, 1);  // Move to the previous part's direction
            this.body[i].lastDirection = prevBodyDir;  // Update to follow the previous part
            prevBodyDir = tempDir;  // Move to the next part
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
                move(GridDirection.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                move(GridDirection.LEFT);
                break;
            case KeyboardEvent.KEY_UP:
                move(GridDirection.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                move(GridDirection.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
