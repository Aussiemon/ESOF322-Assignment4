/**
 * @author Andrew Jenkins, Stephanie McLaren, David Schwehr,
 * Kay Spokas, Matt Rohrlach 
 */



package esof322.a4;

import java.io.Serializable;


/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
				    

				    **/

// interface CaveSite

public interface CaveSite extends Serializable{
  void enter(Player p);
}
