package com.company;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Food extends Button{

    private String name;
    private boolean eatable;
    private String info;

    public Food(String path, int left, int top, int pxWidth, int pxHeight, Stages stage) throws IOException {
        super(path, left, top, pxWidth, pxHeight, stage);
    }
    public Food(String path, int left, int top, int pxWidth, int pxHeight, Stages stage, String name, boolean eatable, String info) throws IOException {
        super(path, left, top, pxWidth, pxHeight, stage);
        this.name = name;
        this.eatable = eatable;
        this.info = info;
    }
    public String getName() {
        return name;
    }

    public boolean isEatable() {
        return eatable;
    }

    public String getInfo() {
        return info;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
