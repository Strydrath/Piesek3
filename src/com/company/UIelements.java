package com.company;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class UIelements {
    private static Button dog;
    //background
    private static Button background, door, bed;
    private static Button buttonNew, buttonLoad, buttonSave, buttonNewR;
    private static Stosik stosik;
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

    public static Stosik getStosik() {
        return stosik;
    }

    public UIelements(){
        try {
            stosik = new Stosik();
            dog = new Button("./res/dog/dog_standing.png",345,420,1,1, Stages.ROOM);
            background = new Button("./res/background/background_empty.png",1,1,1,1, Stages.ROOM);
            door = new Button("./res/background/door.png",780, 135,1,1, Stages.ROOM);
            bed = new Button("./res/background/legowisko.png",195, 570,1,1, Stages.ROOM);
            buttonNew = new Button("./res/background/yellow.png",550,445,2,2, Stages.MENU){
                @Override
                public void onClick(){
                    System.out.println("klikniete");
                    UI.setStage(Stages.ROOM);
                }
            };
            buttonNewR = new Button("./res/background/yellow.png",900,60,1,1, Stages.ROOM);
            buttonLoad = new Button("./res/background/blue.png",820,60,1,1, Stages.ROOM);
            buttonSave = new Button("./res/background/green.png",860,60,1,1, Stages.ROOM);
            avocado = new Food("./res/food/avocado.png",45,420,1,1, Stages.ROOM, "Awocado", true, "Awokado zawiera substancję zwaną persin, która jest toksyczna dla psów i może powodować wymioty i biegunkę."){
                @Override
                public void onClick(){
                    System.out.println("food");
                    Game.setGenerate(true);
                }
            };
            carrot = new Food("./res/food/carrot.png",45,420,1,1, Stages.ROOM, "Marchewka", true, "Szczególnie surowa; Jej twarda konsystencja powoduje, że rozgryzienie jej zajmuje psu dłuższą chwilę, a niewielka zawartość kalorii sprawia, że jest to przekąska odpowiednia dla psów z nadwagą"){
                @Override
                public void onClick(){
                    System.out.println("food");
                    Game.setGenerate(true);
                }
            };
            banana = new Food("./res/food/banana.png",45,420,1,1, Stages.ROOM, "Banan", true, "banany są najs dla piesków"){
                @Override
                public void onClick(){
                    System.out.println("food");
                    Game.setGenerate(true);
                }
            };
            stosik.add(dog);
            stosik.add(background);
            stosik.add(door);
            stosik.add(bed);
            stosik.add(buttonNew);
            stosik.add(buttonNewR);
            stosik.add(buttonLoad);
            stosik.add(buttonSave);
            stosik.add(avocado);
            stosik.add(carrot);
            stosik.add(banana);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Button getButtonNewR() {
        return buttonNewR;
    }
}
