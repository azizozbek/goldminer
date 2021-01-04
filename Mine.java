import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Goldmine where the objects show up.
 * 
 * @AZO 
 * @v1.0
 */
public class Mine extends World
{
    Counter counter = new Counter();

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Mine()
    {    
        /* Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        * with the false parameter make the world unbounded.
        */
        super(800, 600, 1,false);
        
        //add the miner
        Miner miner = new Miner();
        addObject(miner, getWidth()/2, 40);
        
        addObject(counter,57,40);
        getCounter();
        
        //create random Golds
        for (int i=0; i<10; i++)
        {
            addActorAtRandomLocation(new Gold());
        }
        
        //create random Diamonds
        for (int i=0; i<Greenfoot.getRandomNumber(2)+1; i++)
        {
            addActorAtRandomLocation(new Diamond());
        }
        
        //create random Diamonds
        for (int i=0; i<Greenfoot.getRandomNumber(2)+1; i++)
        {
            addActorAtRandomLocation(new Stone());
        }
        
        //create a Sack
        addActorAtRandomLocation(new Sack());
        
        //create the hook
        Hook hook = new Hook();
        addObject(hook, getWidth()/2, 100);
    }
    
    public Counter getCounter(){
        return counter;
    }
    
    private void addActorAtRandomLocation(Actor actor)
    {
        int x = Greenfoot.getRandomNumber(getWidth()-100);
        int y = Greenfoot.getRandomNumber(300);
        addObject(actor, 50+x, 200+y);
    }
}
