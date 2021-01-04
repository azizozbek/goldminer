import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A sack that contains mysterious objects
 * 
 * @AZO & @LUM 
 * @v.1
 */
public class Sack extends Objekt
{
    private int randNr = Greenfoot.getRandomNumber(30);
    protected static int suprise;
    
    public Sack(){
        GreenfootImage image = getImage();        
        image.scale(5+randNr,12+randNr);
        setImage(image);
        
        String[] suprises = {"gold","diamond","stone", "dynamite"};
        this.suprise = 3;//Greenfoot.getRandomNumber(suprises.length);
    }
    
    public void act() 
    {
        Actor hook;
        hook = getOneIntersectingObject(Hook.class);
        if (hook != null){
            setImage("sack_hook.png");
            GreenfootImage image = getImage();      
            image.scale(5+randNr,12+randNr);
            image.rotate(-90);
            setImage(image);
        }
        

        
    }    
}
