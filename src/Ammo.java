import java.util.ArrayList;

/**
 * Write a description of class Ammo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ammo
{
    /** array of bullets */
    private ArrayList<StandardShell> magazine1;  
    
    /** the game */
    private Game game;

    /**
     * Constructor for objects of class Ammo
     */
    public Ammo()
    {
        /**
         * make a new arralist called magazine to store standardshells
         */
        magazine1 = new ArrayList<StandardShell>(40);
    }

    /**
     * store a new standard shell into the clip
     */
    public void loadShell(StandardShell s)
    {
        magazine1.add(s);
    }

    /**
     * remove a standard shell from the world when it reaches 40 shots
     */
    
    public void removeShell()
    {
        int index = 15;
        //game.getSS().destroy();
        magazine1.remove(index);
    }
    
    /**
     * return the number of standard shells in the clip
     */
    public int magazineCap()
    {
        return magazine1.size();
    }
}
