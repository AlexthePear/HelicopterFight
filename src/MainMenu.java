import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    public static GreenfootSound gs = new GreenfootSound("HelicoptersMenu4.mp3");
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        super(1024, 768, 1, true); 
        setBackground("Background3.png");
        // GreenfootImage img = getBackground();
        // img.scale(1024, 768);
        // setBackground(img);
        Player1 display= new Player1(false);
        
        addObject(display, 300, 384);
        addObject(new PlayButton(), 1024 - 125, 200);
        display.display();
        
        
    }
    
    public void act(){
        gs.playLoop();
    }
    
    public static GreenfootSound getSound(){
        return gs;
    }
}
