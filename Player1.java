    /*
@
Player1 Class
Player class used to return X as the weapon
@
 */



public class Player1 extends Player{
    //---------- Assigning variables -----------
    String weapon;

    // Constructor class 
    public Player1(){
        weapon = "X";
    }

    // method to return weapon 
    public String toString(){
        return weapon;
    }

    public String playerName(){
        return "Player 1";
    }

}