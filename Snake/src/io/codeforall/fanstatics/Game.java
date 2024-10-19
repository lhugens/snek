package io.codeforall.fanstatics;

import io.codeforall.fanstatics.apple.AppleFactory;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.snake.Snake;
import io.codeforall.fanstatics.apple.Apple;
import io.codeforall.fanstatics.grid.*;
import io.codeforall.fanstatics.snake.SnakeFactory;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game {
    int cols;
    int rows;
    public boolean gameStarted;
    private SimpleGfxGrid grid;
    private Snake snake;
    private Apple apple;

    private int bestScore;

    public Game(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.gameStarted = false;
        this.grid = SimpleGfxGridFactory.makeGrid(cols, rows);
        this.bestScore = 0;
    }

    public void start() throws InterruptedException {
        class GameStart implements KeyboardHandler {

            public Keyboard keyboard;
            public SimpleGfxGrid grid;
            public boolean gameStarted;

            public Text text;

            public GameStart(SimpleGfxGrid grid, boolean gameStarted) {
                initKeyboard();
                this.gameStarted = gameStarted;
                this.grid = grid;
                this.grid.init();
                this.text = new Text(this.grid.getCols() / 1.8 * this.grid.getCellSize(), this.grid.getRows() / 2 * this.grid.getCellSize(), "Press Space to start");
                this.text.grow(this.grid.getCellSize() * 15, this.grid.getCellSize() * 5);
                this.text.setColor(Color.WHITE);
                this.text.draw();
            }

            private void initKeyboard() {
                this.keyboard = new Keyboard(this);

                KeyboardEvent pressSpace = new KeyboardEvent();
                pressSpace.setKey(KeyboardEvent.KEY_SPACE);
                pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

                this.keyboard.addEventListener(pressSpace);
            }

            @Override
            public void keyPressed(KeyboardEvent keyboardEvent) {
                switch (keyboardEvent.getKey()) {
                    case KeyboardEvent.KEY_SPACE:
                        this.text.delete();
                        this.gameStarted = true;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyboardEvent keyboardEvent) {

            }
        }

        GameStart start = new GameStart(this.grid, this.gameStarted);
        while (!start.gameStarted) {
            Thread.sleep(100);
        }
        this.init();
    }

    public void init() throws InterruptedException{
        class GameRestart implements KeyboardHandler {
            public Keyboard keyboard;
            public SimpleGfxGrid grid;
            private Text text;
            private Text bestScoreText;
            public boolean gameStarted;

            public GameRestart(SimpleGfxGrid grid, boolean gameStarted, int score, int bestScore) {
                initKeyboard();
                this.gameStarted = gameStarted;
                this.grid = grid;

                this.text = new Text(this.grid.getCols() / 2 *  this.grid.getCellSize() , this.grid.getRows() * 2/ 3* this.grid.getCellSize(), "Press Space to restart");
                this.text.grow(this.grid.getCellSize() * 7, this.grid.getCellSize() * 2);
                this.text.setColor(Color.WHITE);
                this.text.draw();

                this.bestScoreText = new Text(this.grid.getCols() / 2 * this.grid.getCellSize() , (this.grid.getRows()+5) * 2/ 3* this.grid.getCellSize(), "Score: " + score + "    Best score: " + bestScore);
                this.bestScoreText.grow(this.grid.getCellSize() * 5, this.grid.getCellSize());
                this.bestScoreText.setColor(Color.MAGENTA);
                this.bestScoreText.draw();
            }

            private void initKeyboard() {
                this.keyboard = new Keyboard(this);

                KeyboardEvent pressSpace = new KeyboardEvent();
                pressSpace.setKey(KeyboardEvent.KEY_SPACE);
                pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                this.keyboard.addEventListener(pressSpace);

                KeyboardEvent pressQ = new KeyboardEvent();
                pressQ.setKey(KeyboardEvent.KEY_Q);
                pressQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                this.keyboard.addEventListener(pressQ);
            }


            @Override
            public void keyPressed(KeyboardEvent keyboardEvent) {
                switch (keyboardEvent.getKey()) {
                    case KeyboardEvent.KEY_SPACE:
                        this.text.delete();
                        this.bestScoreText.delete();
                        this.gameStarted = true;
                        break;
                    case KeyboardEvent.KEY_Q:
                        System.exit(0);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyboardEvent keyboardEvent) {

            }
        }

        this.snake = SnakeFactory.getNewSnake(this.grid);
        this.apple = AppleFactory.getNewApple(this.grid, this.snake);
        this.snake.addApple(this.apple);
        try {
            this.snake.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.snake.updateBestScore();
        this.bestScore = this.snake.getBestScore() > this.bestScore ? this.snake.getBestScore() : this.bestScore;
        Text gameOverText = new Text(this.grid.getCols()/1.8*this.grid.getCellSize(), this.grid.getRows()/2*this.grid.getCellSize(), "Game Over");
        gameOverText.grow(this.grid.getCellSize()*15,this.grid.getCellSize()*5);
        gameOverText.setColor(Color.WHITE);
        gameOverText.draw();
        GameRestart restart = new GameRestart(this.grid, this.gameStarted, this.snake.getScore(), this.bestScore);
        while (!restart.gameStarted) {
            Thread.sleep(100);
        }
        gameOverText.delete();
        this.snake.apple.pos.hide();
        this.snake.scoreText.delete();
        this.snake.pos.hide();
        for (int i = 0; i < this.snake.body.size(); i++) {
            this.snake.body.get(i).hide();
        }
        this.init();
    }

}
