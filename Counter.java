import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

 
/**
 * Counter for score.
 * 
 * @AZO 
 * @v1
 */
public class Counter extends Actor
{
    private int score = 0;

    /**
     * Set score image
     */
    public void act() 
    {
        setImage(new GreenfootImage("Score : " + score, 24, Color.RED, Color.WHITE));
        
    }    
    /**
     * Increase the Score
     *@ int worth = Score to add
    */
    public void addScore(int worth)
    {
        score = score + worth;
    }
}