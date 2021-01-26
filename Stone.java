import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A cheap thing in the way of the miner
 * 
 * @AZO & @LUM 
 * @v.1
 */
public class Stone extends Objekt
{
    private int randNr = Greenfoot.getRandomNumber(10);
    
    /**
     * resize the image
       */
    public Stone(){
        GreenfootImage image = getImage();        
        image.scale(30+randNr,30+randNr);
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
            setImage("stone_hook.png");
            GreenfootImage image = getImage();        
            image.scale(30+randNr,30+randNr);
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
