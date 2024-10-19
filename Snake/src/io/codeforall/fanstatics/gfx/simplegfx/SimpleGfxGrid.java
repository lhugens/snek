package io.codeforall.fanstatics.gfx.simplegfx;

import io.codeforall.fanstatics.grid.Grid;
import io.codeforall.fanstatics.grid.GridColor;
import io.codeforall.fanstatics.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 40;
    public int cols;
    public int rows;

    public Rectangle rectangle;

    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        this.rectangle = new Rectangle(PADDING, PADDING, this.cols*this.getCellSize(), this.rows*this.getCellSize());
        this.rectangle.setColor(new Color(0, 100, 0));
        this.rectangle.draw();
        this.rectangle.fill();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return this.cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return this.rows;
    }

    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() {
        return this.cols * getCellSize();
    }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return this.rows * getCellSize();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * @return the x position of the grid
     */
    public int getX() {
        return PADDING;
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * @return the y position of the grid
     */
    public int getY() {
        return PADDING;
    }

    /**
     * Obtains the pixel width and height of a grid position
     * @return
     */
    public int getCellSize() {
        return 20;
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public SimpleGfxGridPosition makeGridPosition() {
        return new SimpleGfxGridPosition(this);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition(col, row, this);
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return this.PADDING + row * this.getCellSize();
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return this.PADDING + column * this.getCellSize();
    }
}
