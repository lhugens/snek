package io.codeforall.fanstatics.snake;

import io.codeforall.fanstatics.element.Element;
import io.codeforall.fanstatics.element.Head;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGridPosition;
import io.codeforall.fanstatics.grid.GridDirection;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Snake implements KeyboardHandler {
    private Keyboard keyboard;
    private Element head;

    public Snake(SimpleGfxGrid grid, SimpleGfxGridPosition pos){
        this.initKeyboard();
        this.head = new Element(pos, Head.DOWN.picturePath);
    }

    private void move(GridDirection direction){
        this.head.pos.moveInDirection(direction, 1, this.head.picture);
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
