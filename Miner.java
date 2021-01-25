import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Miner that swings his hook to collect valuable objects
 * 
 * @AZO & @LUM
 * @v.1
 */
public class Miner extends Actor
{
    
    public static boolean pullObject;
    public static boolean blowObject;
    /**
     *  Miner to pull objects
     */
    public void act() 
    {
       GifImage pull = new GifImage("miner-pull.gif");
       GifImage blow = new GifImage("miner_dynamite_animation.gif");
       if(pullObject)
        {
             setImage(pull.getCurrentImage());
        }else{
            setImage("miner.png");
        }
        
        if(blowObject)
        {
             setImage(blow.getCurrentImage());
        }else{
            setImage("miner.png");
        }
        
    }    
}
