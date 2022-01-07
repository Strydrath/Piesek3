package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.menu;


public class Game implements Runnable{


    //main window
    public Thread thread;
    public JFrame frame = new JFrame();
    public UI ui = new UI(960,720);


    Dimension canvasSize = ui.getDimension();
    public Input input = new Input();
    public BufferStrategy bs;
    public Graphics g;

    //flaga oznaczająca początek gry, umozliwiajaca uruchomienie watku
    private boolean run = true;
    //dogo
    public Dog dog = new Dog();

    //graphics
    //dog
    public static BufferedImage characterSLn, characterSLm, characterSRn, characterSRm;
    public UIelements uIelements = new UIelements();

    public Food[] foods = new Food[12];

    //funny variables
    private static boolean disposed = false;
    private int rand;

    //mouse stuff
    private int x,y;
    private boolean left, right;


    //public static void changeDispose(){disposed = !disposed;}

    private void createFoods(){

        foods[0] = uIelements.getAvocado();
        foods[1] = uIelements.getCarrot();
        foods[2]= uIelements.getBanana();

    }

    private void generateFood(){
        Random random = new Random();
        rand = random.nextInt(2);
        System.out.println(rand);
        foods[rand].paintArray(g,0);
    }


    public void createDisplay(){
        frame = new JFrame ("Piesek");
        frame.setBounds(100,100,ui.getGAME_WIDTH(), ui.getGAME_HEIGHT());
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setVisible(true);


        ui.setPreferredSize(ui.getDimension());
        ui.setMaximumSize(ui.getDimension());
        ui.setMinimumSize(ui.getDimension());
        ui.setFocusable(false);

        frame.add(ui);
        //frame.addKeyListener(input);
        frame.pack();

        createFoods();
        run();
    }

    public void start(){
        if (run){
            run = false;
            thread = new Thread(this);
            thread.start();
        }
    }

    private void update(){
        if(input.escape){
            System.exit(0);
        }
    }

    private void render() {
     /*   bs = ui.getBufferStrategy();
        if(bs == null){
            ui.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();*/
        g = ui.getGraphics();
        g.setFont(new Font("Consolas",Font.BOLD,25));
        //g.clearRect(0,0,ui.getGAME_WIDTH(),ui.getGAME_HEIGHT());
        g.setColor(Color.pink);
        g.drawRect(0,0,ui.getGAME_WIDTH(),ui.getGAME_HEIGHT());
        System.out.println("mamy render");

        if(ui.getStage() == Stages.MENU){
            ui.drawMenuFrame(g);
            System.out.println("mamy menu");
            if(ui.getStage() == Stages.START_MENU){
                ui.drawStartMenu(g);
            }
            else if(ui.getStage() == Stages.MENU){
                ui.drawNewMenu(g,dog);
            }
            else if (ui.getStage() == Stages.LOAD_MENU) {
                 ui.drawLoadMenu(g);
            }
        }
        else {
            ui.drawRoom(g,dog);
            generateFood();
        }
    }

    @Override
    public void run(){
        System.out.println("mamy run");
        long time;
        long lastTime = System.currentTimeMillis();
        int fps = 1;

        while(run){
            time = System.currentTimeMillis();
            if((double)(time - lastTime) > 1000.0/fps ){
                update();
                input.update();
                render();
                lastTime=time;
            }
        }
    }


}
