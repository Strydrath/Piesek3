package com.company;






import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Main {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.createDisplay();
        game.start();
    }
}

