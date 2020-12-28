import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A gold nugget that is quite expensive
 * 
 * @AZO & @LUM 
 * @v.1
 */
public class Gold extends Objekt
{
    private int piece = 0;
    private int randNr = Greenfoot.getRandomNumber(50);

    public Gold(){
        
        this.VALUE = randNr;
        
        GreenfootImage image = getImage();        
        image.scale(10+randNr,10+randNr);
        setImage(image);
    }
    
    public void act() 
    {
        Actor hook;
        hook = getOneIntersectingObject(Hook.class);
        if (hook != null){
            setImage("gold_hook.png");
            GreenfootImage image = getImage();        
            image.scale(10+randNr,10+randNr);
            setImage(image);
        }          
    }
 
}
