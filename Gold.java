import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A gold nugget that is quite expensive
 * 
 * @AZO & @LUM 
 * @v.1
 */
public class Gold extends Objekt
{
    private int randNr = Greenfoot.getRandomNumber(50);
    /**
     * resize the Images
       */
    public Gold(){
        
        GreenfootImage image = getImage();        
        image.scale(10+randNr,10+randNr);
        setImage(image);

    }
    
    /**
     * If the hook hits the object change the image
    */
    public void act() 
    {
        Actor hook;
        hook = getOneIntersectingObject(Hook.class);
        if (hook != null && gifCounter < 2){
            setImage("gold_hook.png");
            GreenfootImage image = getImage();        
            image.scale(10+randNr,10+randNr);
            image.rotate(-90);
            setImage(image);
        }          

    }
    /**
     * If dynamte used, set the image to blown
    */
    public void blowObject(){
        this.setImage(this.explosion.getCurrentImage());
        this.gifCounter++;
    }

}
