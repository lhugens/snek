package io.codeforall.fanstatics.snake;

import java.util.ArrayList;

import io.codeforall.fanstatics.apple.Apple;
import io.codeforall.fanstatics.apple.AppleFactory;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGridPosition;
import io.codeforall.fanstatics.grid.GridColor;
import io.codeforall.fanstatics.grid.GridDirection;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Snake implements KeyboardHandler {
    public Keyboard keyboard;
    public SimpleGfxGridPosition pos;
    private SimpleGfxGrid grid;
    private int length;
    public ArrayList<SimpleGfxGridPosition> body;
    public Apple apple;
    private boolean hasEatenInLastMove;
    public Text scoreText;
    private Text quitText;
    private int score;
    private int bestScore;

    private boolean gameOver;

    public Snake(SimpleGfxGrid grid, SimpleGfxGridPosition pos){
        this.grid = grid;
        this.gameOver = false;

        this.scoreText = new Text(SimpleGfxGrid.PADDING, 0, "Score: 0");
        this.scoreText.draw();

        this.quitText = new Text( this.grid.getCols() * this.grid.getCellSize() - SimpleGfxGrid.PADDING*1.3, 0, "Press Q to quit");
        this.quitText.draw();

        this.score = 0;
        this.bestScore = 0;
        this.hasEatenInLastMove = false;
        initKeyboard();

        this.length = 1;

        this.pos = pos;
        this.pos.lastDirection = GridDirection.DOWN;
        pos.setColor(GridColor.GREEN);

        this.body = new ArrayList<>(this.length);

        for (int i = 0; i < this.length; i++) {
            body.add((SimpleGfxGridPosition) this.grid.makeGridPosition(this.pos.getCol(), this.pos.getRow() - i - 1));
            body.get(i).setColor(GridColor.GREEN);
            body.get(i).lastDirection = GridDirection.DOWN;
        }
    }

    public int getScore() {
        return score;
    }

    public int getBestScore(){
        return this.bestScore;
    }

    public void updateBestScore(){
        if(this.score > this.bestScore){
            this.bestScore = this.score;
        }
    }

    public void run() throws InterruptedException {
        while (!this.gameOver) {
            try {
                tryMove(this.pos.lastDirection);
                this.checkOverlap();
                Thread.sleep(125);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public void checkOverlap(){
        for(SimpleGfxGridPosition bodyPos : this.body){
            if(bodyPos.getCol() == this.pos.getCol() && bodyPos.getRow() == this.pos.getRow()){
                this.gameOver = true;
                return;
            }
        }
        return;
    }

    public void addApple(Apple apple) {
        this.apple = apple;
    }

    public void move(GridDirection direction) {
        GridDirection prevDir = this.pos.lastDirection;
        this.pos.moveInDirection(direction, 1);
        this.pos.lastDirection = direction;

        GridDirection prevBodyDir = this.body.get(0).lastDirection;

        this.body.get(0).moveInDirection(prevDir, 1);
        this.body.get(0).lastDirection = prevDir;

        for (int i = 1; i < this.body.size(); i++) {
            GridDirection tempDir = this.body.get(i).lastDirection;
            this.body.get(i).moveInDirection(prevBodyDir, 1);
            this.body.get(i).lastDirection = prevBodyDir;
            prevBodyDir = tempDir;
        }
    }

    public void tryMove(GridDirection direction) {
        if(this.gameOver){
            return;
        }
        int tailCol = this.body.get(this.body.size() - 1).getCol();
        int tailRow = this.body.get(this.body.size() - 1).getRow();
        switch (direction) {
            case RIGHT:
                if (!(this.pos.getCol() * this.grid.getCellSize() > this.grid.getCols() * this.grid.getCellSize() - SimpleGfxGrid.PADDING)) {
                    if (this.pos.lastDirection != GridDirection.LEFT) {
                        move(GridDirection.RIGHT);
                    }

                }
                else {
                    this.gameOver = true;
                }
                break;
            case LEFT:
                if (!((this.pos.getCol() + 1) * this.grid.getCellSize() < SimpleGfxGrid.PADDING)) {
                    if (this.pos.lastDirection != GridDirection.RIGHT) {
                        move(GridDirection.LEFT);
                    }
                }
                else {
                    this.gameOver = true;
                }
                break;
            case UP:
                if (!((this.pos.getRow() + 1) * this.grid.getCellSize() < SimpleGfxGrid.PADDING)) {
                    if (this.pos.lastDirection != GridDirection.DOWN) {
                        move(GridDirection.UP);
                    }
                }
                else {
                    this.gameOver = true;
                }
                break;
            case DOWN:
                if (!(this.pos.getRow() * this.grid.getCellSize() > this.grid.getRows() * this.grid.getCellSize() - SimpleGfxGrid.PADDING)) {
                    if (this.pos.lastDirection != GridDirection.UP) {
                        move(GridDirection.DOWN);
                    }
                }
                else {
                    this.gameOver = true;
                }
                break;
        }
        if (this.hasEatenInLastMove) {
            this.grow(tailCol, tailRow);
            this.hasEatenInLastMove = false;
        }
        if (this.pos.getCol() == this.apple.pos.getCol() && this.pos.getRow() == this.apple.pos.getRow()) {
            this.score++;
            this.hasEatenInLastMove = true;
            this.apple.pos.hide();
            this.apple = AppleFactory.getNewApple(this.grid, this);
            this.scoreText.setText("Score: " + this.score);
        }
    }

    public void grow(int col, int row) {
        this.body.add((SimpleGfxGridPosition) this.grid.makeGridPosition(col, row));
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
                tryMove(GridDirection.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                tryMove(GridDirection.LEFT);
                break;
            case KeyboardEvent.KEY_UP:
                tryMove(GridDirection.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                tryMove(GridDirection.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
