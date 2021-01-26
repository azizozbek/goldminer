import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @AZO
 * @v1
 */
public class Start extends Actor
{
    /**
     * start image 
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("down"))
        {
            Mine mine = (Mine) getWorld();
            mine.removeObject(this);
        }
    }    
}
