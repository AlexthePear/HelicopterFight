import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Loading here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReloadBar extends Actor
{
    private String[] imageNames = {"reload1.png", "reload2.png","reload3.png",
            "reload4.png", "reload5.png", "reload6.png",
            "reload7.png", "reload8.png","reload9.png",
            "reload10.png", "reload11.png", "reload12.png"};
    
    
   
    public ReloadBar(){
    
    }
   
    
   
    public void changeImage(int index){
        setImage(imageNames[index]);
    }
}
