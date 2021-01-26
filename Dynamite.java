import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dynamite to explode an object.
 * 
 * @AZO & @LUM
 * @v.1
 */
public class Dynamite extends Actor
{
    public static boolean addDynamite;
    private int count;
    
    /**
     * Resize the image
    */
    public Dynamite(){
        GreenfootImage image = getImage();        
        image.scale(20,34);
        setImage(image);
    }
    
    /**
     * Look if the addDynamite is set to true
       */
    public void act() 
    {
       if(addDynamite){
           addDynamite();
           addDynamite = false;
       }
    }    
    
    /**
       Increase the dynamite count
       */
    public void addDynamite(){
        count++; 
    }
    
    /**
     * Get the current dynamite
       */
    public int getDynamite(){
        return count;
    }
    
    /**
     * Decrease the counter
       */
    public void deleteDynamite(){
    
        count--;
        
    }
}
