 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Weapon
{
    private int timer = 30;
    private Heli p;
    
    public Weapon(Heli h){
        p = h;
        
    }
    
    // public void act(){
        // setLocation(getX(), getY());
    // }

    
    
    public int getTimer(){
        return timer;
    }
    
    abstract public int getDelay();

    public void incrementTimer(){
        timer++;
    }
    
    
    
   
    abstract public Projectile getProjectile(boolean fr, int r, String p);
    
    public void resetTimer(){
        timer = 0;
    }
}
