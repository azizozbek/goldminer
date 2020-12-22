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
    
    public Gold(){
        int randNr = Greenfoot.getRandomNumber(50);
        
        this.VALUE = randNr;
        
        GreenfootImage image = getImage();
        image.scale(10+randNr,10+randNr);
        setImage(image);
    }
    
    public void act() 
    {
                
    }    
}
