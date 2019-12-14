/*
@
Player Class
Player class would not do much 
mostly used as a dummy class 

Supports subclasses : Player 1 - X
                      Player 2 - O
@
 */
public class Player{

    //---------- Assigning variables -----------
    String weapon;

    // Constructor class 
    public Player(){
        weapon = null;
    }

    // method to return weapon 
    public String toString(){
        return weapon;
    }

    public String playerName(){
        return null;
    }
}