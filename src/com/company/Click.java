package com.company;

import java.awt.*;

public class Click {
    private Rectangle rec;
    private int przes = 30;
    public Click(int x, int y, int width, int height){
        rec = new Rectangle(x,y,width,height);
    }
    public boolean clickContains(int x, int y){
        return rec.contains(x,y);
    }
    public void draw(Graphics g){
        g.fillRect(rec.x,rec.y-przes,rec.width,rec.height);
    }
}
