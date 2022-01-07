/*package com.company;

import java.util.ArrayList;
import java.util.List;

public class Stosik {
    private List<Button> buttons;

    public Stosik(){
        buttons = new ArrayList<>();
    }

    public void add(Button button){
        buttons.add(button);
    }
    public List<Button> getButtons(){
        return buttons;
    }

    public void click(int x, int y, Stages stage){
        for(int i =0; i < buttons.size(); i++){
            if(buttons.get(i).toClickOrNotToClick(x,y, stage)){
                buttons.get(i).onClick();
                //break;
            }
        }
    }

}
*/