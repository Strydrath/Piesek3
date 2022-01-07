package com.company;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class UIelements {
    private static Button dog;
    //background
    private static Button background, door, bed;
    private static Button buttonNew, buttonLoad, buttonSave;
    //foods
    private static Food avocado, carrot, banana;

    public static Button getDog() {
        return dog;
    }

    public static Button getBackground() {
        return background;
    }

    public static Button getDoor() {
        return door;
    }

    public static Button getBed() {
        return bed;
    }

    public static Button getButtonNew() {
        return buttonNew;
    }

    public static Button getButtonLoad() {
        return buttonLoad;
    }

    public static Button getButtonSave() {
        return buttonSave;
    }

    public static Food getAvocado() {
        return avocado;
    }

    public static Food getCarrot() {
        return carrot;
    }

    public static Food getBanana() {
        return banana;
    }



    public UIelements(){
        try {
            dog = new Button("./res/dog/dog_standing.png",45,420,1,1, Stages.ROOM);
            background = new Button("./res/background/background_empty.png",1,1,1,1, Stages.ROOM);
            door = new Button("./res/background/door.png",780, 135,1,1, Stages.ROOM);
            bed = new Button("./res/background/legowisko.png",195, 570,1,1, Stages.ROOM);
            buttonNew = new Button("./res/background/yellow.png",345,270,1,1, Stages.ROOM);
            buttonLoad = new Button("./res/background/blue.png",345,375,1,1, Stages.ROOM);
            buttonSave = new Button("./res/background/green.png",1,1,1,1, Stages.ROOM);
            avocado = new Food("./res/food/avocado.png",45,420,1,1, Stages.ROOM, "Awocado", true, "Awokado zawiera substancję zwaną persin, która jest toksyczna dla psów i może powodować wymioty i biegunkę.");
            carrot = new Food("./res/food/carrot.png",45,420,1,1, Stages.ROOM, "Marchewka", true, "Szczególnie surowa; Jej twarda konsystencja powoduje, że rozgryzienie jej zajmuje psu dłuższą chwilę, a niewielka zawartość kalorii sprawia, że jest to przekąska odpowiednia dla psów z nadwagą");
            banana = new Food("./res/food/banana.png",45,420,1,1, Stages.ROOM, "Banan", true, "banany są najs dla piesków");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
