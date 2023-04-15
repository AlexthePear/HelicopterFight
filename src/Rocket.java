import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Projectile
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String[] imageNames = {"Rocket1.png", "Rocket2.png", "Rocket3.png"};
    private int currentImage = 0;
    int speed = 7;
    int rotateMod = 3;
    int originRotation;
    public Rocket(boolean fr, int r, String p){
        super(fr,r,p);
        originRotation = rotation;
    }

    public void act() 
    {
        move(speed);
        animate();
        rotate();
        hitDetection();
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
}
