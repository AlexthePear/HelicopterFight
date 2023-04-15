import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeaponDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponDisplay extends Actor
{
    /**
     * Act - do whatever the WeaponDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String[] imageNames = {"Rocket1.png", "sniper.png","ball.png",
            "HSRocket1.png"};
    
    public void changeImage(int index){
        setImage(imageNames[index]);
    }
}
