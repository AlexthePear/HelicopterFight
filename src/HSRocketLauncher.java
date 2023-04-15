/**
 * Write a description of class HSRocketLauncher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HSRocketLauncher extends Weapon 
{
    private int delay = 160;
    /**
     * Constructor for objects of class RocketLauncher
     */
    public HSRocketLauncher(Heli h)
    {
        super(h);
    }

    public Projectile getProjectile(boolean fr, int r, String p){
        return new HSRocket(fr, r, p);
    }
    
   
    
    public int getDelay(){
        return delay;
    }
}
