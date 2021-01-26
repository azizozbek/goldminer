import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A sack that contains mysterious objects
 * 
 * @AZO & @LUM 
 * @v.1
 */
public class Sack extends Objekt
{
    protected static int suprise;
    /**
       Put the other Objects in an array to return
       */
    public Sack(){
        GreenfootImage image = getImage();        
        image.scale(20,30);
        setImage(image);
        
        String[] suprises = {"gold","diamond","stone", "dynamite"};
        this.suprise = Greenfoot.getRandomNumber(suprises.length);
    }
    
    /**
     * If the hook hits the object change the image
       */
    public void act() 
    {
        Actor hook;
        hook = getOneIntersectingObject(Hook.class);
        if (hook != null && gifCounter < 2){
            setImage("sack_hook.png");
            GreenfootImage image = getImage();      
            image.scale(20,30);
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
