/**
 * @author Matt Rohrlach 
 */

/**
 * @SummaryOfChanges
 * 
 */


package esof322.a4;


/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
				    
**/

// class Level0Door

public class Level0Door extends Door{
  /** In this implementation doors are always locked.
      A player must have the correct key to get through
      a door.  Doors automatically lock after a player
      passes through. */

    private Key myKey;

    /** The door's location. */
    private CaveSite outSite;
    private CaveSite inSite;

    /** We can construct a door at the site. */
    Level0Door(CaveSite out, CaveSite in, Key k){
      outSite = out;
      inSite = in;
      myKey = k;
    }

    /** A player will need the correct key to enter. */
    public void enter(Player p){
       if (p.haveItem(myKey)) {
          System.out.println("Your key works! The door creaks open,");
          System.out.println("and slams behind you after you pass through.");
          if (p.getLoc() == outSite) inSite.enter(p);
          else if (p.getLoc() == inSite) outSite.enter(p); 

          p.setCurrentStatus("Your key works! The door creaks open,\n"
                  + "and slams behind you after you pass through.");
       }
       else {
          p.setCurrentStatus("You don't have the key for this door!\nSorry.");
          System.out.println("You don't have the key for this door!");
          System.out.println("Sorry.");
        }
    }
}


