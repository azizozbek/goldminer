import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

 
/**
 * Counter for score.
 * 
 * @AZO 
 * @v1
 */
public class Counter extends Actor
{
    int score = 0;
    public static boolean addS;
    public static int type;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Score : " + score, 24, Color.RED, Color.WHITE));
        
    }    
     
    public void addScore(int worth)
    {
        score = score + worth;
    }
}