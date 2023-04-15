import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heli here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Heli extends Collision
{
    final int maxSpeed = 4;
    protected int horzSpeed = 0;
    protected int vertSpeed = 0;
    final int maxRotation = 20;
    private int horzTimer = 0;
    private int vertTimer = 0;
    protected boolean facingRight = true;
    protected int rotation = 0;
    private boolean on = true;
    public Heli(){
        
    }
    
    public Heli(boolean b){
        on = b;
    }

    public void act() 
    {
        if(on){
            faceCheck();
            animate();

            shooting();
            move();
        } else if(getWorld() == getWorldOfType(MainMenu.class)){
            display();
        }
    }    
    
    abstract public void display();

    abstract public String horzInputs();

    abstract public String vertInputs();

    public void move(){
        String horzInput = horzInputs();
        String vertInput = vertInputs();
        horzMovementCalc(horzInput);
        vertMovementCalc(vertInput);
        //if(Math.abs(horzSpeed) == Math.abs(vertSpeed)){
        if(horzSpeed != 0 && vertSpeed != 0){
            setLocation(getX() + (int) (horzSpeed/1.25), getY() - (int)(vertSpeed/1.25));
        } else
            setLocation(getX() + horzSpeed, getY() - vertSpeed);
        collisionDetection();

        rotationCalc();
    }
    public void horzMovementCalc(String input){
        horzTimer++;
        if(horzTimer == 8){
            if(horzSpeed <= maxSpeed && horzSpeed >= maxSpeed * -1){
                if (input.equals("right")){
                    horzSpeed++;
                } else if(input.equals("left")){
                    horzSpeed--;
                }

            }
            if (horzSpeed> 0 && !(input.equals("right"))){
                horzSpeed--;
            } else if (horzSpeed < 0 && !(input.equals("left"))){
                horzSpeed++;
            }
            horzTimer = 0;
        }
    }

    public void rotationCalc(){
        rotation = 0 + (4 * horzSpeed);
        setRotation(rotation);
    }

    public void vertMovementCalc(String input){
        vertTimer++;
        if(vertTimer == 8){
            if(vertSpeed <= maxSpeed && vertSpeed >= maxSpeed * -1){
                if (input.equals("up")){
                    vertSpeed++;
                } else if(input.equals("down")){
                    vertSpeed--;
                }

            }
            if (vertSpeed> 0 && !(input.equals("up"))){
                vertSpeed--;
            } else if (vertSpeed < 0 && !(input.equals("down"))){
                vertSpeed++;
            }
            vertTimer = 0;
        }
    }

    public void bulletHit(){
        // Player2 P2 = getWorld().getObjects(Player2.class).get(0);
        // Player1 P1 = getWorld().getObjects(Player1.class).get(0);
        // for(Projectile p: getWorld().getObjects(Projectile.class)){
        // if(p.getParent() == "Player1"){
        // p.removeTouching();
        // }
        // }
    }

    abstract public void animate();

    abstract public void shooting();

    abstract public void faceCheck();

    abstract public String getParent();
    
    public int getXPos(){
        return getX();
    }

    public int getYPos(){
        return getY();
    }

    public boolean getFacingRight(){
        return facingRight;
    }

    public int getRotation(){
        return rotation;
    }

    public void edgeDetection(){
        if(this.isAtEdge()){
            getWorld().addObject( new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        } else if(touch(Obstacle.class)){
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        }
    }

    public void collisionDetection(){
        if(touch(Player2.class)){

            Player2 P2 = getIntersectingObjects(Player2.class).get(0);
            getWorld().addObject(new Explosion(),P2.getX(),P2.getY());
            getWorld().removeObject(P2);
            getWorld().addObject( new Explosion(), getX(), getY());
            getWorld().removeObject(this);

        } 
        else{
            edgeDetection();
        }

    }
    
}
