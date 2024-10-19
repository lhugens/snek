package io.codeforall.fanstatics.gfx.simplegfx;

import io.codeforall.fanstatics.grid.GridDirection;
import io.codeforall.fanstatics.grid.position.AbstractGridPosition;
import io.codeforall.fanstatics.grid.position.GridPosition;
import io.codeforall.fanstatics.grid.GridColor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    public Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;
    private SimpleGfxGrid grid;
    public GridDirection lastDirection;

    /**
     * Simple graphics position constructor
     *
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid) {
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        this.grid = grid;
        this.rectangle = new Rectangle(grid.columnToX(super.getCol()),
                                        grid.rowToY(super.getRow()),
                                        grid.getCellSize(),
                                        grid.getCellSize());
    }

    /**
     * Simple graphics position constructor
     *
     * @param col  position column
     * @param row  position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);
        this.grid = grid;
        this.rectangle = new Rectangle(grid.PADDING + col * grid.getCellSize(),
                grid.PADDING + row * grid.getCellSize(),
                grid.getCellSize(),
                grid.getCellSize());

        this.rectangle.setColor(Color.GREEN);
        this.rectangle.draw();
        this.rectangle.fill();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        //this.rectangle.setColor(Color.GREEN);
        this.rectangle.draw();
        this.rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        this.rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        int oldCol = this.getCol();
        int oldRow = this.getRow();
        super.moveInDirection(direction, distance);
        int newCol = this.getCol();
        int newRow = this.getRow();
        this.rectangle.translate((newCol - oldCol) * this.grid.getCellSize(), (newRow - oldRow) * this.grid.getCellSize());

    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        super.setColor(color);
        this.rectangle.setColor(SimpleGfxColorMapper.getColor(color));
    }


}
