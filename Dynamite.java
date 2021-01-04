import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dynamite to explode an object.
 * 
 * @AZO & @LUM
 * @v.1
 */
public class Dynamite extends Actor
{
    public static boolean addDynamite;
    private int count;
    public void act() 
    {
       if(addDynamite){
           addDynamite();
           addDynamite = false;
       }
       
       for (int i=0; i<10; i++)
       {
           Mine mine = (Mine)getWorld();
           mine.addObject(this, 65, 40);
       }
    }    
    
    public void addDynamite(){
    
        count++;
        
    }
}
