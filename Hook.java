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
    int Ytarget = 1; 
    private int value;
    private Mine mine;
    private GreenfootImage line;
    private Dynamite dynamite = new Dynamite();
    private Miner miner;
    private boolean blowObject = false;
    
    public Hook(Dynamite d, Miner m)
    {
        //make the image double big, so its anchor points is on top
        GreenfootImage base = getImage();
        GreenfootImage image = new GreenfootImage(base.getWidth(), base.getHeight()*2);
        image.drawImage(base, 0, base.getHeight());
        setImage(image);
        image.rotate(-90);
        setRotation(90);
        miner = m;
        dynamite = d;
    }
    
    public void act() 
    { 
        this.mine = (Mine) getWorld();
        hookBasePositionY = getY();

        //Move the hook left to right until key pressed
        if(!stopHook){
            setLocation (getX() + hookSpeed, getY());
            if (atTurningPoint()) {
                hookSpeed = -hookSpeed;
            }
        }
        
        //check if down key pressed
        if (Greenfoot.isKeyDown("down"))
        {
            stopHook = true;
            catchObject = true;
            miner.pullObject = true;
        }


        if(catchObject)
        {
            //check if up key pressed
            if (Greenfoot.isKeyDown("up"))
            {
               //if there is a dynamite, use it
               if(dynamite.getDynamite() >= 1){
                   this.blowObject = true;
                   miner.blowObject = true;
                   dynamite.deleteDynamite();
                   mine.removeObject(dynamite);
               } 
            }
            //draw a Rope to Target
            drawRope(getX(), getY(), getX(), getY() + Ytarget);
            
            //move the Hook to the target
            move(Ytarget);
                
            //end of hook reachable area
            if(getY() >= 350){
                eraseRope();
                drawRope(getX(), getY(), getX(), 100);
                Ytarget--;
            }else{
                Ytarget++;
            }
              
            //check if a gold catched
            Gold gold = (Gold) getOneIntersectingObject(Gold.class);
            if (gold != null) {
                Ytarget = 0;
                eraseRope();                
                int goldSize = gold.getImage().getWidth();
                
                //the size of gold matters to calculate its worth
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
                drawRope(getX(), getY(), getX(), 100);
                getImage().setTransparency(0);
                
                //if up key pressed, the object will be blowed
                if(blowObject){
                   gold.blowObject();
                   value = 0;
                   getImage().setTransparency(100);
                }

            }
            
            Diamond diamond = (Diamond) getOneIntersectingObject(Diamond.class);
            if (diamond != null) {           
                Ytarget = 0;
                eraseRope();
                Ytarget = Ytarget - 5;
                diamond.setRotation(90);
                diamond.move(Ytarget);
                drawRope(getX(), getY(), getX(), 100);
                getImage().setTransparency(0);
                
                if(blowObject){
                   diamond.blowObject();
                   getImage().setTransparency(100);
                }
            }
            
            Stone stone = (Stone) getOneIntersectingObject(Stone.class);
            if (stone != null) {          
                Ytarget = 0;
                eraseRope();
                Ytarget--;
                stone.setRotation(90);
                stone.move(Ytarget);
                drawRope(getX(), getY(), getX(), 100);
                getImage().setTransparency(0);
                
                if(blowObject){
                   stone.blowObject();
                   getImage().setTransparency(100);
                }
            }
            
            Sack sack = (Sack) getOneIntersectingObject(Sack.class);
            if (sack != null) {          
                Ytarget = 0;
                eraseRope();
                Ytarget = Ytarget - 2;
                sack.setRotation(90);
                sack.move(Ytarget);
                drawRope(getX(), getY(), getX(), 100);
                getImage().setTransparency(0);
                
                if(blowObject){
                   sack.blowObject();
                   getImage().setTransparency(100);
                }
            }
            
            // when the hook reaches the top value will summed
             if(getY() <= 100){
                Ytarget = 0;
                eraseRope();
                blowObject = false;
                miner.pullObject = false;
                miner.blowObject = false;
                                
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
                         mine.addObject(dynamite, 150, 40);
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

    /**
     * Checks if there is a object in near
       Class object = the object to check
       */
    public boolean isObjectInRange(Class object)
    {
        return !getObjectsInRange(25, object).isEmpty();
    }
    
    /**
       Define the turning point for the hook
       */
    public boolean atTurningPoint()
    {
        return (getX() <= 50 || getX() >= 750);
    }
      
    /**
       Draw a Rope for the hook
       int x1 = the first point's x coordinate.
       int y1 = the first point's y coordinate.
       int x2 = the second point's x coordinate.
       int y2 = the second point's y coordinate.
       */
    public void drawRope(int x1, int y1, int x2, int y2)
    {        
        this.line = mine.getBackground();
        this.line.setColor(new Color(0,0,0));
        this.line.drawLine(x1, y1, x2, y2);
        mine.setBackground(this.line);
    }
    
    /**
       Erase the drawn Rope
       */
    public void eraseRope(){
        this.mine.setBackground("bg.png");
    }
     
}
