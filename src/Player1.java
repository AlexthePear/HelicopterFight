import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Heli
{
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private static int weaponIndex = 0;
    private Weapon[] weapons = { new RocketLauncher(this), new Sniper(this), new BouncyWeapon(this), new HSRocketLauncher(this)};
    private String[] leftImageNames = {"LP1Heli1.png","LP1Heli2.png","LP1Heli3.png","LP1Heli4.png" };
    private String[] imageNames = {"P1Heli1.png","P1Heli2.png","P1Heli3.png","P1Heli4.png" };

    private int currentImage = 0;
    private boolean once = true;
    private boolean On = true;
    public Player1(){

    }

    public Player1(boolean b){
        super(b);
    }

    public void display(){
        On = false;
        currentImage++;
        if(currentImage >= imageNames.length){
            currentImage = 0;
        }
        if(facingRight){

            setImage(imageNames[currentImage]);
            GreenfootImage img = getImage();
            img.scale(img.getWidth() * 5, img.getHeight() * 5);
            setImage(img);
        } else {
            setImage(leftImageNames[currentImage]);
            GreenfootImage img = getImage();
            img.scale(img.getWidth() * 5, img.getHeight() * 5);
            setImage(img);
        }
    }

    public String horzInputs(){
        if (Greenfoot.isKeyDown("d")){
            return "right";
        }
        else if (Greenfoot.isKeyDown("a")){
            return "left";

        } else
            return "";
    }

    public String vertInputs(){
        if (Greenfoot.isKeyDown("w")){
            return "up";
        } else if (Greenfoot.isKeyDown("s")){
            return "down";
        } else
            return"";

    }

    public void shooting(){
        ((MyWorld)getWorld()).getP1WD().changeImage(weaponIndex);
        if(weapons[weaponIndex].getTimer()/(weapons[weaponIndex].getDelay()/12) >= 11){
            ((MyWorld)getWorld()).getP1Bar().changeImage(11);
        } else 
            ((MyWorld)getWorld()).getP1Bar().changeImage(weapons[weaponIndex].getTimer()/(weapons[weaponIndex].getDelay()/12));
        if(Greenfoot.isKeyDown("e") && once){
            weaponIndex++;
            once = false;
        } else if(!Greenfoot.isKeyDown("e")){
            once = true;
        }
        if(weaponIndex == weapons.length){
            weaponIndex = 0;
        }
        if (Greenfoot.isKeyDown("f")){
            //weapons[weaponIndex].shoot();
            if(weapons[weaponIndex].getTimer() >= weapons[weaponIndex].getDelay()){
                getWorld().addObject(weapons[weaponIndex].getProjectile(facingRight, rotation, "Player1"),getX(), getY());
                weapons[weaponIndex].resetTimer();
            }
        }
        weapons[weaponIndex].incrementTimer();
        //weapons[weaponIndex].shoot();
    }

    /*
     * Checs to see if the helicopter is facing the enemy
     */
    public void faceCheck(){
        if(!getWorld().getObjects(Player2.class).isEmpty()){
            Player2 P2 = getWorld().getObjects(Player2.class).get(0);
            if(horzSpeed <= 2 && vertSpeed <= 2){
                if(P2.getX() >= getX()){
                    facingRight = true;
                } else
                    facingRight = false;
            }
        }
    }

    public void animate(){

        currentImage++;
        if(currentImage >= imageNames.length){
            currentImage = 0;
        }
        if(facingRight){

            setImage(imageNames[currentImage]);
        } else {
            setImage(leftImageNames[currentImage]);
        }
    }

    public void collisionDetection(){
        if(touch(Player2.class)){

            Player2 P2 = getIntersectingObjects(Player2.class).get(0);
            getWorld().addObject(new Explosion(),P2.getX(),P2.getY());
            getWorld().removeObject(P2);
            getWorld().addObject( new Explosion(), getX(), getY());
            getWorld().removeObject(this);

        } else{
            edgeDetection();
        }

    }

    public String getParent(){
        return "Player1";
    }

}
