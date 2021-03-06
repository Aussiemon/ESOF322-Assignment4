/**
 * @author Andrew Jenkins, Stephanie McLaren, David Schwehr,
 * Kay Spokas, Matt Rohrlach 
 */




package esof322.a4;


/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

	  To compile: javac AdventureGame.java
	       To run:     java AdventureGame

		    The main routine is AdventureGame.main
				    
**/


// class Treasure

public class Treasure extends Item {
    boolean fake = false;
    
    public Treasure(){
        //Regular treasure
    }
    public Treasure(boolean inFake){
        if(inFake){
            fake = true;
        }
    }
    @Override
    public boolean isFake(){
        if (fake == true) {
            return true;
        }
        else return false;
    }
    
}
