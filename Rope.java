import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Seil vom Anker.
 * 
 * @author AZO 
 * @version 0.1
 */
public class Rope extends Actor
{
    
    private GreenfootImage rope; // Draw Hooks rope
    
    public void act() 
    {
        Mine mine = (Mine) getWorld();
        GreenfootImage img = mine.getBackground();
        img.setColor(new Color(10,255,20));
        setImage(rope);
 
    }
    
    public void clear()
    {
        rope.clear();
        setImage(rope);
    }
    
    public void drawLine(int x1, int y1, int x2, int y2)
    {      
        Mine mine = (Mine) getWorld();
        rope.drawLine(x1, y1, x2, y2);           
        mine.setBackground(rope);
    }
}