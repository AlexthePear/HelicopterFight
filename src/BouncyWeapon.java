/**
 * Write a description of class BouncyWeapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BouncyWeapon extends Weapon 
{
    //bouncy bullets don't work yet :/
    int delay = 70;
    public BouncyWeapon(Heli h){
        super(h);
    }
    
    public Projectile getProjectile(boolean fr, int r, String p){
        return new BouncyBullet(fr, r, p);
    }
    
    public int getDelay(){
        return delay;
    }
}   
