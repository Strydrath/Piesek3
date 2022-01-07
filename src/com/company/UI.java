package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;

public class UI extends JPanel implements MouseListener {
    private final int GAME_WIDTH;
    private final int GAME_HEIGHT;
    private Stages stage;

    //new colors
    private final Color burgundy =  new Color(92,30,40);
    private final Color darkgundy = new Color(79,26,35);
    private final Color darkgundyALFA = new Color(79,26,35,220);
    private final Color my_pink = new Color(255,235,238);
    private final Color brownish= new Color(62, 39,35);
    private final Color almost_white = new Color (255, 245, 247);
    private final Color night = new Color (21, 24,43, 200);
    private final Color yellowish = new Color(253,191,6);
    private final Color whiteyellowish = new Color( 255,224,130);
    private final Color bluish = new Color(63,82,181);
    private final Color whitebluish = new Color( 92,107,192);
    private final Color greenish = new Color(27,94,32);
    private final Color whitegreenish = new Color(46,125,50);

    private final Font font1 = new  Font("Consolas",Font.BOLD,25);


    public UI(int game_width, int game_height) {
        GAME_WIDTH = game_width;
        GAME_HEIGHT = game_height;
        stage = Stages.MENU;
        addMouseListener(this);
    }

    public int getGAME_WIDTH() {
        return GAME_WIDTH;
    }

    public int getGAME_HEIGHT() {
        return GAME_HEIGHT;
    }


    public Dimension getDimension(){
        return new Dimension(GAME_WIDTH,GAME_HEIGHT);
    }

    public void drawStartMenu(Graphics g){
        g.setColor(whiteyellowish);
        g.fillRect(345,270, 270,61);
        g.setColor(whitebluish);
        g.fillRect(345,375, 270,61);
        UIelements.getButtonNew().paintArray(g,0);
        UIelements.getButtonLoad().paintArray(g,0);
        g.setColor(burgundy);
        g.drawString("Nowa Gra", 435, 310); //300
        g.drawString("Wczytaj Grę", 435, 415);//405
    }
    public void drawNewMenu(Graphics g, Dog dog) {
        g.setColor(whiteyellowish);
        g.fillRect(295,175, 370,370);

        g.setColor(brownish);
        g.drawString("Nowa Gra", 420, 225);
        g.setColor(burgundy);
        g.drawString("Wpisz imię dla pieska:", 330, 325);
        g.setColor(darkgundy);
        g.fillRect(360, 355, 240, 45);
        g.setColor(whiteyellowish);
        g.drawString(dog.getName(), 375 , 385);

        g.setColor(brownish);
        g.fillRect(340,445, 60,60);

        g.setColor(yellowish);
        g.fillRect(550,445, 60,60);
    }
    public void drawLoadMenu(Graphics g){
        g.setColor(whitebluish);
        g.fillRect(295, 175, 370, 370);

        g.setColor(brownish);
        g.drawString("Wczytaj Grę", 420, 225);

        g.setColor(brownish);
        g.fillRect(340, 445, 60, 60);

        g.setColor(bluish);
        g.fillRect(550, 445, 60, 60);
    }
    public void drawSaveMenu(Graphics g){
        g.setColor(whitegreenish);
        g.fillRect(295, 175, 370, 370);

        g.setColor(brownish);
        g.drawString("Wczytaj Grę", 420, 225);
    }
    public void drawPauseMenu(Graphics g, Stages stage, Dog dog){
        g.setColor(darkgundyALFA);
        g.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        g.setColor(brownish);
        g.fillRect(280,160, 400,400);
        g.setColor(almost_white);
        g.fillRect(295,175, 370,370);

        if(stage == Stages.MENU)
            drawNewMenu(g, dog);
        else
        if(stage == Stages.LOAD_MENU)
            drawLoadMenu(g);
        else
            drawSaveMenu(g);
    }

    public void drawMenuFrame(Graphics g){
        g.setColor(burgundy);
        g.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        g.setColor(brownish);
        g.fillRect(280,160, 400,400);
        g.setColor(darkgundy);
        g.fillRect(295,175, 370,370);
    }

    private void drawMagicBars(Graphics g, Dog dog) {
        g.setColor(new Color(250, 250, 250)); //antyaliazing eh
        g.fillRect(465, 150, 160, 180);
        g.setColor(new Color(89, 43, 43));
        g.fillRect(465, 150, 150, 30); //health
        g.setColor(new Color(59, 59, 9));
        g.fillRect(465, 195, 150, 30); //food
        g.setColor(new Color(20, 69, 17));
        g.fillRect(465, 240, 150, 30); //energy
        g.setColor(new Color(16, 57, 71));
        g.fillRect(465, 285, 150, 30); //sanity

        g.setColor(Color.red);
        g.fillRect(465, 150, dog.getHealth() * 15, 30); //health
        g.setColor(Color.yellow);
        g.fillRect(465, 195, dog.getFood() * 15, 30); //food
        g.setColor(Color.green);
        g.fillRect(465, 240, dog.getEnergy() * 15, 30); //energy
        g.setColor(Color.blue);
        g.fillRect(465, 285, dog.getSanity() * 15, 30); //sanity
    }

    public void drawLocalTime(Graphics g) {

        LocalTime localTime = LocalTime.now();
        String time = "";
        if (localTime.getHour() < 10)
            time += "0";
        time += localTime.getHour() + " : ";
        if (localTime.getMinute() < 10)
            time += "0";
        time += localTime.getMinute() + " : ";
        if (localTime.getSecond() < 10)
            time += "0";
        time += localTime.getSecond();

        g.setColor(burgundy);
        g.drawString(time, 150, 240);
    }

    public Stages getStage() {
        return stage;
    }

    public void drawRoom(Graphics g, Dog dog){
        g.setColor(my_pink);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        UIelements.getBackground().paintArray(g,0);
        UIelements.getBed().paintArray(g,0);
        UIelements.getDoor().paintArray(g,0);

        //back buttons
        UIelements.getButtonNew().paintArray(g,0);
        UIelements.getButtonLoad().paintArray(g,0);
        UIelements.getButtonSave().paintArray(g,0);

        drawMagicBars(g, dog);
        drawLocalTime(g);
        UIelements.getDog().paintArray(g,0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
