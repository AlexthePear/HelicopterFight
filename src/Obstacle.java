import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    /**
     * Act - do whatever the obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public String vertCheck(Projectile p){
        if(p.getX() < getX() - (getImage().getWidth()/2) || p.getX() > getX() + (getImage().getWidth()/2)){
            return "vert";
        } 
        return "";
    }
    
    public String horzCheck(Projectile p){
        if (p.getY() < getY() - (getImage().getHeight()/2)|| p.getY() > getY() + (getImage().getHeight()/2)){
            return "horz";
        }
        return "";
    }
    public int cornerCheck(Projectile p, int r){
        if(p.getY() <= getY() - (getImage().getHeight()/2 - 1) && p.getX() <= getX() - (getImage().getWidth()/2 - 1)){
            return 225;
        } else if(p.getY() >= getY() + (getImage().getHeight()/2 - 1) && p.getX() <= getX() - (getImage().getWidth()/2 - 1)){
            return 135;
        } else if(p.getY() <= getY() - (getImage().getHeight()/2 - 1) && p.getX() >= getX() + (getImage().getWidth()/2 - 1)){
            return 315;
        } else if(p.getY() >= getY() + (getImage().getHeight()/2 - 1) && p.getX() >= getX() + (getImage().getWidth()/2 - 1)){
            return 45;
        }
        return r;
    }
    // public String cornerCheck(Projectile p){
        // if(p.getY() == getY() - (getImage().getHeight()/2) && p.getX() < getX() - (getImage().getWidth()/2)){
            // return "NW";
        // } else if(p.getY() == getY() + (getImage().getHeight()/2) && p.getX() < getX() - (getImage().getWidth()/2)){
            // return "SW";
        // } else if(p.getY() == getY() - (getImage().getHeight()/2) && p.getX() < getX() + (getImage().getWidth()/2)){
            // return "NE";
        // } else if(p.getY() == getY() + (getImage().getHeight()/2) && p.getX() < getX() + (getImage().getWidth()/2)){
            // return "SE"
        // }
        // return "";
    // }
}
