import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Miner that swings his hook to collect valuable objects
 * 
 * @AZO & @LUM
 * @v.1
 */
public class Miner extends Actor
{
    private int minerBasePositionY;
    private int minerSpeed = 3;
    private boolean stopMiner = false;
    private int leftTurn = 100;
    private int rightTurn = 700;
    int Ytarget = 1; 
    private int value;
    /**
     * Act - do whatever the Miner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
        Mine mine = (Mine) getWorld();
        
        minerBasePositionY = getY();
        
        if(!stopMiner){
            setLocation (getX() + minerSpeed, getY());
            if (atTurningPoint()) {
                minerSpeed = -minerSpeed;
            }
        }
                if (Hook.stopHook = true)
        {
            stopMiner = true;
        } else {
            stopMiner = false;
        }
    }    
        public boolean atTurningPoint()
    {
        
        return (getX() <= leftTurn || getX() >= rightTurn);
    }
}
