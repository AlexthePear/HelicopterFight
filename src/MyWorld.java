import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static MyWorld main;
    public boolean isRunning = false;
    private int timer = 0;
    public static ReloadBar p1Bar;
    public static ReloadBar p2Bar;
    public static WeaponDisplay p1WD;
    public static WeaponDisplay p2WD;
    public static int p1Score = 0;
    public static int p2Score = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1, true); 
        //setBackground("Background.png");
        setBackground("Background1.jpg");
        //funnySetup();
        //regularSetup();
        main = this;

        Grid g = new Grid(1,1, 32);

        placeGrid(new Grid(getWidth()/g.getCS(),getHeight()/g.getCS(), g.getCS()));
        p1Bar = new ReloadBar();
        p2Bar = new ReloadBar();
        addObject(p1Bar, 100, 720);
        addObject(p2Bar, 924, 720);
        p1WD = new WeaponDisplay();
        p2WD = new WeaponDisplay();
        addObject(p1WD, 250, 700);
        addObject(p2WD, 774, 700);
        showText("ESC to quit",50,30);
    }
    
    public static WeaponDisplay getP1WD(){
        return p1WD;
    }
    
    public static WeaponDisplay getP2WD(){
        return p2WD;
    }
    
    public static ReloadBar getP1Bar(){
        return p1Bar;
    }
    
    public static ReloadBar getP2Bar(){
        return p2Bar;
    }

    public void act(){
        //infiniteRespawn();
        randomRespawn();
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new MainMenu());
        }
        showText("P1 Score : " + p1Score,100,650);
        showText("P2 Score : " + p2Score,924,650);
    }

    public void randomRespawn(){
        while(getObjects(Player1.class).isEmpty()){
            int p1X = (int)(Math.random()* getWidth()/2);
            int p1Y = (int)(Math.random()* getHeight());
            int count = 0;
            for(int x = -45; x < 45; x++){
                for(int y = -25; y < 25; y++){
                    if(getObjectsAt(p1X + x,p1Y + y,Actor.class).isEmpty()){
                        count++;
                    }
                }
            }
            if(count >= 4500){
                addObject(new Player1(),p1X, p1Y);
            }
        } 
        while (getObjects(Player2.class).isEmpty()){
            int p2X = (int)(Math.random()* getWidth()/2 + getWidth()/2);
            int p2Y = (int)(Math.random()* getHeight());
            int count = 0;
            for(int x = -45; x < 45; x++){
                for(int y = -25; y < 25; y++){
                    if(getObjectsAt(p2X + x,p2Y + y,Actor.class).isEmpty()){
                        count++;
                    }
                }
            }
            if(count >= 4500){
                addObject(new Player2(),p2X, p2Y);
            }
            
        }
    }

    public void infiniteRespawn(){
        if(getObjects(Player1.class).isEmpty()){
            addObject(new Player1(),300, 500);
        } else if(getObjects(Player2.class).isEmpty()){
            addObject(new Player2(),800, 400);
        }
    }

    public void regularSetup(){
        addObject(new Player1(),300, 500);
        addObject(new Player2(),800, 400);
        //spawnSquare(512,334, 3);
        //spawnObstacle(700, 600, 64);
        //spawnObstacle(400,200,64);
        //spawnSquare(700, 600, 2);
        //spawnSquare(300, 200, 2);
        // addObject(new Obstacle(), 512, 334);
        // addObject(new Obstacle(), 512, 384);
        // addObject(new Obstacle(), 512, 434);
        // addObject(new Obstacle(), 512, 484);
    }

    public void spawnSquare(int x, int y, int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                addObject(new Obstacle(), x + i * 50, y + j * 50);
            }
        }
    }

    public void spawnObstacle(int x, int y, int scale){
        Obstacle obj = new Obstacle();
        GreenfootImage objImg = obj.getImage();
        objImg.scale(scale, scale);
        obj.setImage(objImg);
        addObject(obj, x, y);
    }

    
    public void funnySetup(){
        addObject(new Player1(),300, 500);
        addObject(new Player1(),300, 50);
        addObject(new Player1(),300, 100);
        addObject(new Player1(),300, 150);
        addObject(new Player1(),300, 250);
        addObject(new Player2(),700, 400);
        addObject(new Player2(),700, 100);
        addObject(new Player2(),700, 150);
        addObject(new Player2(),700, 250);
        addObject(new Player2(),700, 300);
    }

    
    public void placeGrid(Grid g){
        int[][] grid = g.getGrid();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length ; j++){
                
                if(grid[i][j]== 1){

                    spawnObstacle(i*g.getCS() + g.getCS()/2, j*g.getCS() +g.getCS()/2, g.getCS());
                }

            }
            
        }
    }
}
