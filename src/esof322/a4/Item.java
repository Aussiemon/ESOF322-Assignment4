/**
 * @author Andrew Jenkins, Stephanie McLaren, David Schwehr,
 * Kay Spokas, Matt Rohrlach 
 */





package esof322.a4;

import java.io.Serializable;

/**
 * Adventure Game Program Code Copyright (c) 1999 James M. Bieman
 *
 * To compile: javac AdventureGame.java To run: java AdventureGame
 *
 * The main routine is AdventureGame.main
 *
 *
 */
// class Item
public class Item implements Serializable{
    private String description;

    public void setDesc(String d) {
        description = d;
    }

    public String getDesc() {
        return description;
    }
    
    public boolean isFake(){
        return false;
    }
}
