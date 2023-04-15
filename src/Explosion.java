import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String[] imageNames = {"Explosion1.png", "Explosion2.png","Explosion3.png",
            "Explosion4.png", "Explosion5.png", "Explosion6.png",
            "Explosion7.png", "Explosion8.png","Explosion9.png",
            "Explosion10.png",};
    private int currentImage = 0;
    private int timer = 0;
    public Explosion(){
        Greenfoot.playSound("Explosion.mp3");
    }
    public void act() 
    {   
        timer++;
        if(timer == 5){
            currentImage++;
            if(currentImage >= imageNames.length){
                getWorld().removeObject(this);
                currentImage = 0;
            }
            setImage(imageNames[currentImage]);
            timer = 0;
        }
    }
}
