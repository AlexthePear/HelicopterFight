import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BouncyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BouncyBullet extends Projectile
{
    int speed = 7;
    int timer = 0;
    int delay = 350;

    /**
     * Act - do whatever the BouncyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BouncyBullet(boolean fr, int  r, String p){
        super(fr, r, p);
    }

    public void act() 
    {   
        if(this != null){
            move(speed);
            hitDetection();
            destroyTimer();
            //edgeDetection();
        }
    }    
   

    public void hitDetection(){

        if(isTouching(Obstacle.class)){
            Obstacle obj = (Obstacle)getIntersectingObjects(Obstacle.class).get(0);
            String v = obj.vertCheck(this);
            String h = obj.horzCheck(this);
            
            if(getRotation() == 180 || getRotation() == 0){
                if((int)(Math.random() * 2) == 1)
                turn(180 - (int)(Math.random() * 15) + 1);
                else turn(180 + (int)(Math.random() * 15) + 1);
                move(speed);
            } else if (h.equals("horz") && v.equals("vert")){
                setRotation(obj.cornerCheck(this, getRotation()));
                move(speed);
            }
            else if(h.equals("horz")){
                turn(-2*getRotation());
                move(speed);
            } else if (v.equals("vert")){
                turn(180-2*getRotation());
                move(speed);
            }

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

    public void destroyTimer(){
        timer++;
        if(timer >= delay){
            timer = 0;
            if(getWorld() != null)
            getWorld().removeObject(this);
        }
    }
}
