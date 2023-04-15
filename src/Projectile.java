
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Collision
{
    protected int speed = 30;

    protected String parent = "";
    protected boolean facingRight = true;
    protected int rotation = 0;

    Projectile(boolean fr, int r, String p){
        parent = p;
        facingRight = fr;
        if (facingRight){
            rotation =  r;
            setRotation(rotation);

        } else{
            rotation = r + 180;
            setRotation(rotation);
        }
    }

    public void act() 
    {

        move(speed);
        hitDetection();
        //edgeDetection();

    }    

    // public void edgeDetection(){
    // for(Projectile p: getWorld().getObjects(Projectile.class)){
    // if(p.isAtEdge() && p == this){
    // getWorld().removeObject(p);

    // }
    // }
    // }

    public void hitDetection(){
        if(touch(Obstacle.class)){
            getWorld().removeObject(this);
        }
        else if(touch(Player1.class) && this.getParent().equals("Player2")){
            Player1 P1 = getIntersectingObjects(Player1.class).get(0);
            getWorld().addObject(new Explosion(), P1.getX(),P1.getY());
            MyWorld.p2Score++;
            this.removeTouching(Player1.class);

            getWorld().removeObject(this);

        } else if(touch(Player2.class) && this.getParent().equals("Player1")){
            Player2 P2 = getIntersectingObjects(Player2.class).get(0);
            getWorld().addObject(new Explosion(), P2.getX(),P2.getY());
            MyWorld.p1Score++;
            this.removeTouching(Player2.class);
            getWorld().removeObject(this);
        }
        else if(this.isAtEdge()){
            getWorld().removeObject(this);

        }

    }

    public String getParent(){
        return parent;
    }

    public GreenfootImage getImg(){
        return getImage();
    }

}
