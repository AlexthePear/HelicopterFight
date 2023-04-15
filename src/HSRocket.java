
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HSRocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HSRocket extends Projectile
{
    private String[] imageNames = {"HSRocket1.png", "HSRocket2.png"};
    private int currentImage = 0;
    int speed = 4;
    int rotateMod = 3;
    int originRotation;
    int turnSpeed = 1;
    int delay = 240;
    int timer = 0;
    int hsRange = 300;
    public HSRocket(boolean fr, int r, String p){
        super(fr,r,p);
        originRotation = rotation;
    }

    public void act() 
    {  
            move(speed);
            animate();
            heatDetection();
            //rotate();
            hitDetection();
            destroyTimer();
        
    }    

    

    public void destroyTimer(){
        timer++;
        if(timer >= delay){
            timer = 0;
            if(getWorld() != null){
                getWorld().addObject(new Explosion(), getX(), getY());
                getWorld().removeObject(this);
            }
        }
    }

    public void rotate(){
        if(originRotation + 15 == rotation || originRotation - 15 == rotation){
            rotateMod *= -1;
        } 
        rotation += rotateMod;
        setRotation(rotation);
    }

    public void animate(){

        currentImage++;
        if(currentImage >= imageNames.length){
            currentImage = 0;
        }

        setImage(imageNames[currentImage]);
    }

    public void hitDetection(){

        if(touch(Obstacle.class)){
            getWorld().addObject(new Explosion(), getX(),getY());
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
            getWorld().addObject(new Explosion(), getX(),getY());
            getWorld().removeObject(this);

        }

    }

    public void heatDetection(){
        if(!getObjectsInRange(hsRange, Player2.class).isEmpty() && this.getParent().equals("Player1")){
            Heli h = getObjectsInRange(hsRange+10, Player2.class).get(0);
            //int originalRot = getRotation();
            turnTowards(h.getX(), h.getY());
            int targetRotation = getRotation();
            setRotation(originRotation);
            posRotCalc(originRotation, targetRotation);
        } else if(!getObjectsInRange(hsRange, Player1.class).isEmpty() && this.getParent().equals("Player2")){
            Heli h = getObjectsInRange(hsRange+10, Player1.class).get(0);
            //int originalRot = getRotation();
            turnTowards(h.getX(), h.getY());
            int targetRotation = getRotation();
            setRotation(originRotation);
            posRotCalc(originRotation, targetRotation);
        }  else{

            //rotate();
        }
    }

    public void posRotCalc(int oR, int tR){
        int currentRotation = oR;

        int facingRotation = tR;
        if (facingRotation - currentRotation > 180) facingRotation -= 360;
        if (facingRotation - currentRotation < -180) currentRotation -= 360;
        setRotation(  currentRotation+(turnSpeed*(int)Math.signum(facingRotation-currentRotation)));
        originRotation =  currentRotation+(turnSpeed*(int)Math.signum(facingRotation-currentRotation));
    }
}
