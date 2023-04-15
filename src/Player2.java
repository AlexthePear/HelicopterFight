import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Heli
{
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int weaponIndex = 0;
    private Weapon[] weapons = { new RocketLauncher(this), new Sniper(this), new BouncyWeapon(this), new HSRocketLauncher(this)};
    private String[] leftImageNames = {"LP2Heli1.png","LP2Heli2.png","LP2Heli3.png","LP2Heli4.png" };
    private String[] imageNames = {"P2Heli1.png","P2Heli2.png","P2Heli3.png","P2Heli4.png" };
    private int currentImage = 0;
    private boolean once = true;

    public Player2(){
        facingRight = false;
    }
    
    public void display(){
    }

    public String horzInputs(){
        if (Greenfoot.isKeyDown("right")){
            return "right";
        }
        else if (Greenfoot.isKeyDown("left")){
            return "left";

        } else
            return "";
    }

    public String vertInputs(){
        if (Greenfoot.isKeyDown("up")){
            return "up";
        } else if (Greenfoot.isKeyDown("down")){
            return "down";
        } else
            return"";

    }

    public void shooting(){
        ((MyWorld)getWorld()).getP2WD().changeImage(weaponIndex);
        if(weapons[weaponIndex].getTimer()/(weapons[weaponIndex].getDelay()/12) >= 11){
            ((MyWorld)getWorld()).getP2Bar().changeImage(11);
        } else 
            ((MyWorld)getWorld()).getP2Bar().changeImage(weapons[weaponIndex].getTimer()/(weapons[weaponIndex].getDelay()/12));
        
        if(Greenfoot.isKeyDown("shift") && once){
            weaponIndex++;
            once = false;
        } else if(!Greenfoot.isKeyDown("shift")){
            once = true;
        }
        if(weaponIndex == weapons.length){
            weaponIndex = 0;
        }
        if (Greenfoot.isKeyDown("space")){
            if(weapons[weaponIndex].getTimer() >= weapons[weaponIndex].getDelay()){
                getWorld().addObject(weapons[weaponIndex].getProjectile(facingRight, rotation, "Player2"),getX(), getY());
                weapons[weaponIndex].resetTimer();
            }
        }
        weapons[weaponIndex].incrementTimer();
    }

    /*
     * Checs to see if the helicopter is facing the enemy
     */
    public void faceCheck(){
        if(!getWorld().getObjects(Player1.class).isEmpty()){
            Player1 P1 = getWorld().getObjects(Player1.class).get(0);

            if(horzSpeed <= 2 && vertSpeed <= 2){
                if(P1.getX() >= getX()){
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
        if(touch(Player1.class)){

            Player1 P1 = getIntersectingObjects(Player1.class).get(0);
            getWorld().addObject(new Explosion(),P1.getX(),P1.getY());
            getWorld().removeObject(P1);
            getWorld().addObject( new Explosion(), getX(), getY());
            getWorld().removeObject(this);

        } else{
            edgeDetection();
        }

    }
public String getParent(){
        return "Player2";
    }

    
}
