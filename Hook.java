import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Object;
import java.util.*;
import java.lang.String;

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
    private int value;
        
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
            
        Mine mine = (Mine) getWorld();
        
        hookBasePositionY = getY();
        
        if(!stopHook){
            setLocation (getX() + hookSpeed, getY());
            if (atTurningPoint()) {
                hookSpeed = -hookSpeed;
            }
        }
             
        if (Greenfoot.isKeyDown("down"))
        {
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
              
            Gold gold = (Gold) getOneIntersectingObject(Gold.class);
            if (gold != null) {
                              
                Ytarget = 0;
                int goldSize = gold.getImage().getWidth();

                if(goldSize >= 50 ){
                     Ytarget--;
                     value = 5;
                }else if (goldSize >= 40){
                    Ytarget = Ytarget - 2;
                    value = 3;
                }else if (goldSize >= 30){
                    Ytarget = Ytarget - 3;
                    value = 2;
                }else if(goldSize >= 10) {
                   Ytarget = Ytarget - 4;
                   value = 1;
                }
                
                gold.setRotation(90);
                gold.move(Ytarget);
                getImage().setTransparency(0);
            }
            
            Diamond diamond = (Diamond) getOneIntersectingObject(Diamond.class);
            if (diamond != null) {           
                Ytarget = 0;
                Ytarget = Ytarget - 5;
                diamond.setRotation(90);
                diamond.move(Ytarget);
                getImage().setTransparency(0);
            }
            
            Stone stone = (Stone) getOneIntersectingObject(Stone.class);
            if (stone != null) {          
                Ytarget = 0;
                Ytarget--;
                stone.setRotation(90);
                stone.move(Ytarget);
                getImage().setTransparency(0);
            }
            
            Sack sack = (Sack) getOneIntersectingObject(Sack.class);
            if (sack != null) {          
                Ytarget = 0;
                Ytarget = Ytarget - 2;
                sack.setRotation(90);
                sack.move(Ytarget);
                getImage().setTransparency(0);
            }
            
             if(getY() <= 100){
                Ytarget = 0;
                                
                if(gold != null){
                     mine.getCounter().addScore(value);
                     mine.removeObject(gold);
                }
                
                if(diamond != null){
                     mine.getCounter().addScore(10); 
                     mine.removeObject(diamond);
                }
                
                if(stone != null){
                     mine.getCounter().addScore(1); 
                     mine.removeObject(stone);
                }
                
                if(sack != null){
                     int suprise = sack.suprise;
                     switch(suprise){
                         case 0:
                         mine.getCounter().addScore(5);
                         case 1:
                         mine.getCounter().addScore(10);
                         case 2:
                         mine.getCounter().addScore(1);
                         case 3:
                         Dynamite dynamite = new Dynamite();
                         dynamite.addDynamite();
                          
                     }
                     mine.removeObject(sack);
                }
                
                getImage().setTransparency(255);
                stopHook = false;

                catchObject = false;
                Ytarget = 1;
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
