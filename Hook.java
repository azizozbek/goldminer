import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Object;
/**
* Hook that swings around and catches objects to bring to the Miner
* 
* @AZO & @LUM 
* @v.1
*/
public class Hook extends Actor
{
    private int hookBasePositionY;
    private int hookSpeed = 3;
    private boolean stopHook = false;
    private boolean catchObject = false;
    private int leftTurn = 100;
    private int rightTurn = 700;
    int Ytarget = 1;
    private Actor gold;
    
    
    public Hook()
    {
        //make the image double big, so its anchor points is on top
        GreenfootImage base = getImage();
        GreenfootImage image = new GreenfootImage(base.getWidth(), base.getHeight()*2);
        image.drawImage(base, 0, base.getHeight());
        setImage(image);
        image.rotate(-90);
        setRotation(90);   
    }
    
    public void act() 
    {   
    
        hookBasePositionY = getY();
        
        if(!stopHook){
            setLocation (getX() + hookSpeed, getY());
            if (atTurningPoint()) {
                hookSpeed = -hookSpeed;
            }
        }
             
        
        if(Greenfoot.isKeyDown("down")){
            stopHook = true;
            catchObject = true;
        }
        
        if(catchObject)
        {
            
            getWorld().getBackground().setColor(Color.BLACK);
            //getWorld().getBackground().drawLine(getX(), getY(), getX(), getY() + Ytarget);
            
            move(Ytarget);
                
            if(getY() >= 350){
                Ytarget--;
            }else{
                Ytarget++;
            }

            Actor actor = getOneIntersectingObject(Gold.class);
            if (actor != null) {
                
                Ytarget--;
                actor.setRotation(90);
                actor.move(Ytarget);
                getImage().setTransparency(0);
            }
            
             if(getY() <= 100){
                Ytarget = 0;
            }
            
            
        }
    }

    public boolean isObjectInRange(Class object)
    {
        return !getObjectsInRange(25, object).isEmpty();
    }
    
    public boolean atTurningPoint()
    {
        
        return (getX() <= leftTurn || getX() >= rightTurn);
    }
      
     
}
