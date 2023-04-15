import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Actor
{
    public PlayButton(){
        GreenfootImage image = getImage();
        image.scale(250,100);
        setImage(image);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            ((MainMenu)getWorld()).getSound().stop();
            Greenfoot.setWorld(new MyWorld());
        }
    }    
}
