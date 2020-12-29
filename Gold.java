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
    public static int worth = 1;

    public Gold(){
               
        GreenfootImage image = getImage();        
        image.scale(10+randNr,10+randNr);
        setImage(image);
        
    }
    
    public void act() 
    {
        worth = 1;
        if(randNr > 10){
            worth = 2;
        }
        if(randNr > 20){
            worth = 3;
        }
        if (randNr > 30){
            worth = 4;
        }
        if (randNr > 40){
            worth = 5;
        }
        
        Actor hook;
        hook = getOneIntersectingObject(Hook.class);
        if (hook != null){
            setImage("gold_hook.png");
            GreenfootImage image = getImage();        
            image.scale(10+randNr,10+randNr);
            image.rotate(-90);
            setImage(image);
        }          
    }
 
}
