package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Button {
    private BufferedImage bufferedImage;
    public int left;
    public int top;
    public int pxWidth;
    public int pxHeight;
    public boolean clickable = true;
    public Stages stage;

    public void setClickable(boolean c){
        clickable = c;
    }

    public Button(String path, int left, int top, int pxWidth, int pxHeight, Stages stage) throws IOException {
        this.bufferedImage = ImageIO.read(new File(path));
        this.left = left;
        this.top = top;
        this.pxWidth = pxWidth;
        this.pxHeight = pxHeight;
        this.stage = stage;
    }

    public Button(int left, int top, int pxWidth, int pxHeight, Stages stage) throws IOException {
        this.left = left;
        this.top = top;
        this.pxWidth = pxWidth;
        this.pxHeight = pxHeight;
        this.stage = stage;
    }

    public void paintArray(Graphics g, int looper) {
        // 0 - to kolor brak koloru (przezroczystaosc)
        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                if (bufferedImage.getRGB(x,y) != 0) {
                    g.setColor(new Color(bufferedImage.getRGB(x,y)));
                    g.fillRect(x * pxWidth + left, y * pxHeight + top, pxWidth, pxHeight);
                }
            }
        }
    }
    public void paint(Graphics g, int looper) {
        // 0 - to kolor brak koloru (przezroczystaosc)
        g.drawImage(bufferedImage,left,top,null);

    }

    public boolean toClickOrNotToClick(int screenX, int screenY, Stages stage){
        if(clickable == true) {
            if (stage == this.stage) {
                int x = screenX - left;
                int y = screenY - top;
                if (x < 0 || y < 0) {
                    return false;
                }
                x = x / pxWidth;
                y = y / pxHeight;
                if ((x >= 0 && x < bufferedImage.getWidth()) && (y >= 0 && y < bufferedImage.getHeight()))
                    return bufferedImage.getRGB(x, y) == 0 ? false : true;
            }
        }
        return false;

    }
    public void onClick(){
        //....
    }
}

