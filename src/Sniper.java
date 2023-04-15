/**
 * Write a description of class Sniper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sniper extends Weapon 
{
    private int delay = 90;
    /**
     * Constructor for objects of class Sniper
     */
    public Sniper(Heli h)
    {
        super(h);
    }
    
    public int getDelay(){
        return delay;
    }
    
    public Projectile getProjectile(boolean fr, int r, String p){
        return new SniperBullet(fr, r, p);
    }

    
}
