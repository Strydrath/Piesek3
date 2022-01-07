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


        Game.characterSLn = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/dog/dog_standing.png")));
        Game.characterSLm = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/dog/dog_standing_left_mouth.png")));
        Game.characterSRn = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/dog/dog_standing_right.png")));
        Game.characterSRm = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/dog/dog_standing_right_mouth.png")));

        Game.background = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/background/background_empty.png")));
        Game.buttonNew = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/background/yellow.png")));
        Game.buttonLoad = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/background/blue.png")));
        Game.buttonSave = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/background/green.png")));
        Game.bed = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/background/legowisko.png")));
        Game.door = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/background/door.png")));

        Game.avocado = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/food/avocado.png")));
        Game.carrot = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/food/carrot.png")));
        Game.banana = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/food/banana.png")));

        /*JFrame okno = new JFrame();
        Panel panel = new Panel();
        okno.setDefaultCloseOperation(3);
        okno.setBounds(100,100,640,640);
        okno.add(panel);
        okno.setVisible(true); */


        game.createDisplay();
        game.start();
    }
}

