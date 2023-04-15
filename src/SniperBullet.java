import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SniperBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SniperBullet extends Projectile
{
    private int speed = 65;
    public SniperBullet(boolean fr, int r, String p){
        super(fr, r, p);
    } 
    
    public void act() 
    {

        move(speed);
        hitDetection();
        
        //edgeDetection();

    }    

}
