/*package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class Panel extends JPanel implements MouseListener {
    public Timer timer;
    public static int looper = 0;
    public static Stages actualStage;
    ImageIcon obrazekOryginal;
    Stosik stosik;
    Stosik jedzonko;
    int wylosowane=0;
    Button awokado;
    Button marchew;
    Button background;
    Button bed;
    Button door;
    Button buttonNew;
    Button buttonSave;
    Button buttonLoad;
    Button currentJedzonko;
    boolean init = false;
    Button menu;
    Button newGame;


    public Panel(){
        addMouseListener(this);
        this.stosik = new Stosik();
        this.jedzonko = new Stosik();
        actualStage = Stages.MENU;
        timer = new Timer(1000, this::actionPerformed);
        timer.start();
    }
    public void actionPerformed(ActionEvent e) {
        //If still loading, can't animate.
        looper++;
        //System.out.println(looper);
        repaint();
    }
    public void initRoom() throws IOException {
        if(!init) {


            awokado = new Button("./res/food/avocado.png", 45,420, 1, 1, Stages.ROOM) {
                @Override
                public void onClick() {
                    //Game.changeDispose();
                }
            };
            marchew = new Button("./res/food/carrot.png", 45,420, 1, 1, Stages.ROOM) {
                @Override
                public void onClick() {
                    //Game.changeDispose();
                }
            };
            background = new Button("./res/background/background_empty.png", 1,1, 1, 1, Stages.ROOM);
            bed = new Button("./res/background/legowisko.png", 195,570, 1, 1, Stages.ROOM);
            door = new Button("./res/background/door.png", 780,135, 1, 1, Stages.ROOM);
            buttonNew = new Button("./res/background/yellow.png", 52*15, 2*15, 1, 1, Stages.ROOM);
            buttonSave = new Button("./res/background/green.png", 60*15, 2*15, 1, 1, Stages.ROOM);
            buttonLoad = new Button("./res/background/blue.png", 56*15, 2*15, 1, 1, Stages.ROOM);

            stosik.add(background);
            stosik.add(bed);
            stosik.add(door);
            jedzonko.add(awokado);
            jedzonko.add(marchew);
            stosik.add(buttonNew);
            stosik.add(buttonSave);
            stosik.add(buttonLoad);
            init = true;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        try {
            initRoom();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Button b: stosik.getButtons()) {
            if(b.stage == actualStage)
                b.paintArray(g, looper);
        }
        jedzonko.getButtons().get(wylosowane).paintArray(g,0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Stages tmpStage = actualStage;
        stosik.click(e.getX(), e.getY(),actualStage);
        if(jedzonko.getButtons().get(wylosowane).toClickOrNotToClick(e.getX(), e.getY(),actualStage)){
            jedzonko.getButtons().get(wylosowane).onClick();
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

*/
