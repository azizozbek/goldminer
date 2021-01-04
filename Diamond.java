import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A valuable diamond that has a high value
 * 
 * @AZO & @LUM 
 * @v.1
 */
public class Diamond extends Objekt
{
    private int randNr = Greenfoot.getRandomNumber(50);

    public Diamond(){        
        
    }
    public void act() 
    {
        Actor hook;
        hook = getOneIntersectingObject(Hook.class);
        if (hook != null){
            setImage("diamond_hook.png");
            GreenfootImage image = getImage();        
            image.rotate(-90);
            setImage(image);
        }
    }

}
