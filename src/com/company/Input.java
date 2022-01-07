package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private boolean[] button;
    public boolean escape;
    public boolean enter;


    public Input(){
        button = new boolean[256];
    }

    public void update(){

        escape = button[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        button[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

        /* button[e.getKeyCode()] = false;
        if(Game.menu){
            if(e.getKeyCode() == 65){
                Game.name.lenght() +=  "a";
            }
        }*/

        if(Game.menu || Game.info){
            if(e.getKeyCode() == 10){
                Game.menu=false;
                Game.info=false;
            }
        }
    }
}
