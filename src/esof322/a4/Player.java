/**
 * @author Andrew Jenkins, Stephanie McLaren, David Schwehr, Kay Spokas, Matt
 * Rohrlach
 */

/**
 * @SummaryOfChanges
 *  Added starting location attribute to player with get method
 */
package esof322.a4;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 * Adventure Game Program Code Copyright (c) 1999 James M. Bieman
 *
 * To compile: javac AdventureGame.java To run: java AdventureGame
 *
 * The main routine is AdventureGame.main
 *
 *
 */
public class Player implements Serializable{
    
    private Room startLoc;
    private boolean setStartLoc = false;

    private Room myLoc;

    private Item[] myThings = new Item[2];

    private int itemCount = 0;

    private String status = "";

    public void setRoom(Room r) {
        myLoc = r;
        if(!setStartLoc){
            startLoc = myLoc;
            setStartLoc = true;
        }
    }

    public String look() {
        return myLoc.getDesc();
    }

    public void go(int direction) {
        myLoc.exit(direction, this);
    }

    public void pickUp(Item i) {
        if (itemCount < 2) {
            myThings[itemCount] = i;
            itemCount++;
            myLoc.removeItem(i);
            //Items were just stolen (fake gold bars)
            if(myLoc.itemThief()){
                itemCount = 0;
                clearMyThings();
                JOptionPane.showMessageDialog(null, myLoc.getThiefStatus());
                myLoc.resetItemThief();
            }
        }
    }

    public boolean haveItem(Item itemToFind) {
        for (int n = 0; n < itemCount; n++) {
            if (myThings[n].equals(itemToFind)) {
                return true;
            }
        }
        return false;
    }

    public void drop(int itemNum) {
        if (itemNum > 0 & itemNum <= itemCount) {
            switch (itemNum) {
                case 1: {
                    myLoc.addItem(myThings[0]);
                    myThings[0] = myThings[1];
                    myThings[1] = null;
                    itemCount--;
                    break;
                }
                case 2: {
                    myLoc.addItem(myThings[1]);
                    myThings[1] = null;
                    itemCount--;
                    break;
                }
            }
        }
    }

    public void setLoc(Room r) {
        myLoc = r;
    }

    public Room getLoc() {
        return myLoc;
    }

    public String showMyThings() {
        String outString = "";
        for (int n = 0; n < itemCount; n++) {
            outString = outString + Integer.toString(n + 1) + ": "
                    + myThings[n].getDesc() + " ";
        }
        return outString;
    }

    public String currentStatus() {
        return status;
    }

    public void setCurrentStatus(String status) {
        this.status = status;
    }

    /**
     * Get the players list of items
     *
     * @return List of items held by the player
     */
    public Item[] getPlayerItemList() {
        return myThings;
    }

    public boolean handsFull() {
        return itemCount == 2;
    }

    public boolean handsEmpty() {
        return itemCount == 0;
    }

    public int numItemsCarried() {
        return itemCount;
    }
    
    public Room getStartLoc(){
        return startLoc;
    }
    
    public void clearMyThings(){
        myThings = new Item[2];
    }

}
