import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Goldmine where the objects show up.
 * 
 * @AZO 
 * @v1.0
 */
public class Mine extends World
{

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
        
        //create the hook
        Hook hook = new Hook();
        addObject(hook, getWidth()/2, 100);

       
        //create random Golds
        for (int i=0; i<10; i++)
        {
            addActorAtRandomLocation(new Gold());
        }
           
        
    }
    
    private void addActorAtRandomLocation(Gold gold)
    {
        int x = Greenfoot.getRandomNumber(getWidth()-50);
        int y = Greenfoot.getRandomNumber(300);
        addObject(gold, x, 200+y);
    }
}
