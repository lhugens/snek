package io.codeforall.fanstatics.apple;

import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGridPosition;
import io.codeforall.fanstatics.grid.position.GridPosition;
import io.codeforall.fanstatics.snake.Snake;

public class AppleFactory {
    public static Apple getNewApple(SimpleGfxGrid grid, Snake snake) {
        boolean bool = false;
        GridPosition pos = grid.makeGridPosition();

        while (!bool) {
            pos = grid.makeGridPosition();
            bool = true;

            if (pos.getCol() == snake.pos.getCol() && pos.getRow() == snake.pos.getRow()) {
                bool = false;
                continue;
            }

            for (int i = 0; i < snake.body.size(); i++) {
                if (snake.body.get(i).getCol() == pos.getCol() && snake.body.get(i).getRow() == pos.getRow()) {
                    bool = false;
                    break;
                }
            }
        }

        return new Apple(grid, (SimpleGfxGridPosition) pos);
    }

}
