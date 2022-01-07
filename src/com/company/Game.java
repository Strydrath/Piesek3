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


public class Game implements Runnable{


    //main window
    public Thread thread;
    public JFrame frame = new JFrame();
    public Canvas canvas = new Canvas();
    //public Panel panel;

    public final int Width=960, Height=720;
    Dimension canvasSize = new Dimension(Width,Height);
    public Input input = new Input();
    public BufferStrategy bs;
    public Graphics g;

    //loading etc
    public static boolean menu = true; //true;
    private boolean start_menu = true;
    private boolean new_menu = false;
    private boolean load_menu = false;
    private boolean run = false;
    public static boolean info = false;

    //status
    public static final int  MAX = 10;
    public static class Status{
        public static int health = 6;
        public static int food = 2;
        public static int energy = 9;
        public static int sanity = 7;
    }
    public Status status;
    //public boolean pet = false, play = false;


    //graphics
    //dog
    public static BufferedImage characterSLn, characterSLm, characterSRn, characterSRm;
    public BufferedImage[] dog = new BufferedImage[4];
    //background
    public static BufferedImage background, door, bed;
    public static BufferedImage buttonNew, buttonLoad, buttonSave;
    //foods
    public static BufferedImage avocado, carrot, banana;
    public static class Food {
        public String name;
        public BufferedImage image;
        public boolean eatable;
        public String info;
    }
    public Food[] foods = new Food[12];

    //funny variables
    private String name = "Mura";
    private static boolean disposed = false;
    private int rand;

    //mouse stuff
    private int x,y;
    private boolean left, right;
        //clicky stuff - menu
    private final Click newGame = new Click(345,270, 270,61); //345,270, 270+15,61
    private final Click loadGame = new Click(345,375, 270,61); //345,375, 270,61
    private final Click backGame = new Click(340,445, 60,60); //340,445, 60,60
    private final Click nextGame = new Click(550,475,60,60);
        //clicky stuff - inside menu
    private final Click loadInGame = new Click(52*15,2*15, 30,30);
    private final Click backInGame = new Click(56*15,2*15, 30,30);
    private final Click nextInGame = new Click(60*15,2*15,30,30);
        //clicky stuff - background
    private final Click foodBox = new Click(45,420,90,90);
    private final Click doorBox = new Click(45,420,90,90);
    private final Click bedBox = new Click(45,420,90,90);
    //private final Click foodBox = new Click(45,420,90,90);
        //thedog
    private final Click dogBox = new Click(45,420,90,90);

    //new colors
    Color burgundy =  new Color(92,30,40);
    Color darkgundy = new Color(79,26,35);
    Color darkgundyALFA = new Color(79,26,35,220);
    Color my_pink = new Color(255,235,238);
    Color brownish= new Color(62, 39,35);
    Color almost_white = new Color (255, 245, 247);
    Color night = new Color (21, 24,43, 200);
    Color yellowish = new Color(253,191,6);
    Color whiteyellowish = new Color( 255,224,130);
    Color bluish = new Color(63,82,181);
    Color whitebluish = new Color( 92,107,192);
    Color greenish = new Color(27,94,32);
    Color whitegreenish = new Color(46,125,50);

    Font font1 = new  Font("Consolas",Font.BOLD,25);

    //public static void changeDispose(){disposed = !disposed;}

    private void createFoods(){

        for(int i=0;i<foods.length;i++)
            foods[i]=new Food();


        foods[0].name = "Awokado";
        foods[0].image = avocado;
        foods[0].eatable = false;
        foods[0].info = "Awokado zawiera substancję zwaną persin, która jest toksyczna dla psów i może powodować wymioty i biegunkę.";

        foods[1].name = "Marchewka";
        foods[1].image = carrot;
        foods[1].eatable = true;
        foods[1].info = "Szczególnie surowa; Jej twarda konsystencja powoduje, że rozgryzienie jej zajmuje psu dłuższą chwilę, a niewielka zawartość kalorii sprawia, że jest to przekąska odpowiednia dla psów z nadwagą";

        foods[2].name = "Banan";
        foods[2].image = banana;
        foods[2].eatable = true;
        foods[2].info = "banany są najs dla piesków";
    }

    private void startMenu(){
        g.setColor(whiteyellowish);
        g.fillRect(345,270, 270,61);
        g.setColor(whitebluish);
        g.fillRect(345,375, 270,61);
        g.drawImage(buttonNew, 345 , 270, 60,60,null);
        g.drawImage(buttonLoad,  345, 375, 60,60,null);
        g.setColor(burgundy);
        g.drawString("Nowa Gra", 435, 310); //300
        g.drawString("Wczytaj Grę", 435, 415);//405

        if(mouseInGame() && left){
            if(newGame.clickContains(frame.getMousePosition().x, frame.getMousePosition().y)) {
                new_menu = true;
                start_menu = false;
            }
        }
    }
    private void newMenu() {

        g.setColor(whiteyellowish);
        g.fillRect(295,175, 370,370);

        g.setColor(brownish);
        g.drawString("Nowa Gra", 420, 225);
        g.setColor(burgundy);
        g.drawString("Wpisz imię dla pieska:", 330, 325);
        g.setColor(darkgundy);
        g.fillRect(360, 355, 240, 45);
        g.setColor(whiteyellowish);
        g.drawString(name, 375 , 385);

        g.setColor(brownish);
        g.fillRect(340,445, 60,60);

        g.setColor(yellowish);
        g.fillRect(550,445, 60,60);


    }
    private void loadMenu(){

        g.setColor(whitebluish);
        g.fillRect(295, 175, 370, 370);

        g.setColor(brownish);
        g.drawString("Wczytaj Grę", 420, 225);

        g.setColor(brownish);
        g.fillRect(340, 445, 60, 60);

        g.setColor(bluish);
        g.fillRect(550, 445, 60, 60);

    }
    private void saveMenu(){
        g.setColor(whitegreenish);
        g.fillRect(295, 175, 370, 370);

        g.setColor(brownish);
        g.drawString("Wczytaj Grę", 420, 225);
    }
    private void pauseMenu(){
        g.setColor(darkgundyALFA);
        g.fillRect(0,0,Width,Height);
        g.setColor(brownish);
        g.fillRect(280,160, 400,400);
        g.setColor(almost_white);
        g.fillRect(295,175, 370,370);

        if(new_menu)
            newMenu();
        if(load_menu)
            loadMenu();
        //if(save)
        saveMenu();
    }
    private void menuFrame(){
        g.setColor(burgundy);
        g.fillRect(0,0,Width,Height);
        g.setColor(brownish);
        g.fillRect(280,160, 400,400);
        g.setColor(darkgundy);
        g.fillRect(295,175, 370,370);
    }

    private void magicBars() {

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
        g.fillRect(465, 150, Status.health * 15, 30); //health
        g.setColor(Color.yellow);
        g.fillRect(465, 195, Status.food * 15, 30); //food
        g.setColor(Color.green);
        g.fillRect(465, 240, Status.energy * 15, 30); //energy
        g.setColor(Color.blue);
        g.fillRect(465, 285, Status.sanity * 15, 30); //sanity
    }
    private void writeLocalTime() {

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
    private void generateFood(){
        if(!disposed) {

            Random random = new Random();
            rand = random.nextInt(2);
            System.out.println(rand);

            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            disposed = true;
        }

        g.drawImage(foods[rand].image,45,330,null);
        if(mouseInGame() && left){
            if(foodBox.clickContains(frame.getMousePosition().x, frame.getMousePosition().y)){
                disposed = false;
            }
        }
    }
    private void drawDog(){
        g.drawImage(dog[0], 480, 420, null);
    }
    private void drawRoom(){
        g.setColor(my_pink);
        g.fillRect(0, 0, Width, Height);
        g.drawImage(background, 0, 0, null);
        g.drawImage(bed, 195, 570, null);
        g.drawImage(door, 780, 135, null);

        //back buttons
        g.drawImage(buttonNew, 52*15, 2*15,null);
        g.drawImage(buttonLoad, 56*15, 2*15,null);
        g.drawImage(buttonSave, 60*15, 2*15,null);

        magicBars();
        writeLocalTime();
        drawDog();
        generateFood();
    }

    private void changeStatus(){
        /*
        public void walk(){
            Status.health += 2;
            Status.energy -= 5;
            Status.sanity += 4;

            Status.health %= 11;
            Status.sanity %= 11;
        }
        public void good_food(){
            Status.health += 2;
            Status.food += 4;
            Status.energy += 2;
            Status.sanity += 1;
        }
        public void bad_food(){
            Status.health -= 6;
            Status.sanity -= 2;
        }
        public void sleep(){
            Status.health += 2;
            Status.energy += 10;
            Status.sanity += 3;
        }
        //public void pet()
        */
    }
    private void checkStatus(){             //if more than MAX or lss than 0, so death or sth
            /*
    public int check(Game.Status){
        int fl = 0;
        if(Status.health <=0)
            fl += 1;
        if(Status.food <=0)
            fl += 10;
        if(Status.energy <=0)
            fl += 100;
        if(Status.sanity <=0)
            fl += 1000;

        Status.health %= 11;
        Status.food %= 11;
        Status.energy %= 11;
        Status.sanity %= 11;

        return fl;
    }
    public void walk(){
        Status.health += 2;
        Status.sanity += 2;
        Status.energy -= 2;


    }
     */
    }


    public void createDisplay(){
        frame = new JFrame ("Piesek");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        //panel = new Panel();
        //frame.add(panel);

        frame.setLocation(dim.width / 2 - Width / 2, dim.height / 2 - Height / 2);
        frame.setSize(Width, Height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(Width, Height));
        canvas.setMaximumSize(canvasSize);
        canvas.setMinimumSize(canvasSize);
        canvas.setFocusable(false);

        frame.add(canvas);
        canvas.addMouseListener(new CustomListener());
        frame.addKeyListener(input);
        frame.pack();

        run=true;

        dog[0] = characterSLn;
        dog[1] = characterSLm;
        dog[2] = characterSRn;
        dog[3] = characterSRm;

        createFoods();

        run();
    }

    public void start(){
        if (!run){
            run = true;
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
        bs = canvas.getBufferStrategy();
        if(bs == null){
            canvas.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.setFont(new Font("Consolas",Font.BOLD,25));
        g.clearRect(0,0,Width,Height);
        g.setColor(Color.pink);
        g.drawRect(0,0,Width, Height);
        System.out.println("mamy render");

        if(menu){
            menuFrame();
            System.out.println("mamy menu");
            if(start_menu){
                startMenu();
            }
            else if(new_menu){
                newMenu();
                if(mouseInGame() && left){
                    if(backGame.clickContains(frame.getMousePosition().x, frame.getMousePosition().y)){
                        start_menu = true;
                        new_menu = false;
                    }
                    else if(nextGame.clickContains(frame.getMousePosition().x, frame.getMousePosition().y)){
                        menu = false;
                    }
                }
            }
            else if (load_menu) {
                 loadMenu();
            }
        }
        else {
            drawRoom();
        }

            //food
    }

    @Override
    public void run(){
        System.out.println("mamy run");
        long time;
        long lastTime = System.currentTimeMillis();
        int fps = 60;

        while(run){
            time = System.currentTimeMillis();
            if((double)(time - lastTime) > (double) 1/fps ){
                update();
                input.update();
                render();
            }
        }
    }

    public boolean mouseInGame(){
        boolean fl = false;
        if(MouseInfo.getPointerInfo().getLocation().x > frame.getX()
           && MouseInfo.getPointerInfo().getLocation().x < frame.getX() + Width
           && MouseInfo.getPointerInfo().getLocation().y > frame.getY()
           && MouseInfo.getPointerInfo().getLocation().y < frame.getY() + Height)
        {
            fl = true;
        }
        return fl;
    }

    private class CustomListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1){
                left = true;
            }
            if(e.getButton() == MouseEvent.BUTTON2){
                right = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            left = false;
            right = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
