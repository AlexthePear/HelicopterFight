/**
 * Write a description of class RocketLauncher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketLauncher extends Weapon 
{
    
    
   
    private int delay = 65;
    /**
     * Constructor for objects of class RocketLauncher
     */
    public RocketLauncher(Heli h)
    {
        super(h);
    }

    public Projectile getProjectile(boolean fr, int r, String p){
        return new Rocket(fr, r, p);
    }
    
   
    
    public int getDelay(){
        return delay;
    }
    
}
