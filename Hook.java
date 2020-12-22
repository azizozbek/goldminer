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
    private int ropeSpeed = 2;
    private double turningSpeed;
    private int leftTurn = 270;
    private int rightTurn = 480;
    private int swing = 1;
    private int rotate = 30;
    private int direction = 1;
    int Xcenter;
    int Ycenter;
    private boolean stop = false;
    int speed = 0;
    int speedY = 0;
    int speedS = 0;
    int speedX = 0;
    int radius;
    
    public Hook(){
        //make the image double big, so its anchor points is on top
        GreenfootImage base = getImage();
        GreenfootImage image = new GreenfootImage(base.getWidth(), base.getHeight()*2);
        image.drawImage(base, 0, base.getHeight());
        setImage(image);
       
     }
    
    public void act() 
    {
        if(!stop){
            Xcenter = getX();
            Ycenter = getY();
            getWorld().getBackground().setColor(Color.BLACK);
            getWorld().getBackground().drawLine(400, 100, Xcenter, Ycenter);
            
            setLocation (getX() + ropeSpeed, getY()+swing);
            setRotation(rotate);
            if (atTurningPoint()) {
                ropeSpeed = -ropeSpeed;
                rotate = -rotate;
                swing = 0;
            }
        }
        
        if(Greenfoot.mouseClicked(getWorld())){
            stop = true;
            speedS = ((Ycenter - getY())/40) - speed/10 - 2;
            turnTowards(Xcenter, Ycenter);
        move(radius);
        turn(speedS);
        move(-radius);
             speedX = speedS*(Ycenter - getY())/40;
        speedY = -speedS*(Xcenter-getX())/34;
            
        }
        
        
    }
    public int getSwing()
    {
        return swing;
    }
    
    public boolean atTurningPoint()
    {
        return (getX() <= leftTurn || getX() >= rightTurn);
    }
      
    //TODO
    private void moves() 
    { 
        if ((direction < 0 && getX() == 350) || (direction > 0 && getX() == getWorld().getWidth()-350)){
            direction = -direction;
            turn(0);
          }
        // movement  
        
        move(direction);        
        
    }
}
