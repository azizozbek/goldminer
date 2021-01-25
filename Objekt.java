import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Organisatory Class for Objects
 * 
 * @AZO & @LUM 
 * @v.1
 */
public class Objekt extends Actor
{
    protected GifImage explosion = new GifImage("explosion.gif");
    protected int gifCounter = 0;
    protected boolean useDynamite = false;
    //Avoid overlapping random other objects
    protected void addedToWorld(World world)
    {
        while (isTouching(Gold.class))
        {
            move(Greenfoot.getRandomNumber(20));
        }
        
        while (isTouching(Diamond.class))
        {
            move(Greenfoot.getRandomNumber(20));
        }
        
        while (isTouching(Stone.class))
        {
            move(Greenfoot.getRandomNumber(20));
        }
    }
}
