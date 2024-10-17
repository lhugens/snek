package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Snake...sss....");
        Game game = new Game(40, 40);
        try {
            game.start();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
