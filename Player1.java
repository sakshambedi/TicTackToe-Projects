    /*
@
Player1 Class
Player class used to return X as the weapon
@
 */



public class Player1 extends Player{
    //---------- Assigning variables -----------
    String weapon;
    String playerName = "";

    // Constructor class 
    public Player1(){
        weapon = "X";
        playerName = "Player 1";
    }

    // method to return weapon 
    public String toString(){
        return weapon;
    }

    // method to return player name
    public String playerName(){
        return "Player 1";
    }

    // Method name personalised named player objects
    public Player1(String name){
        weapon = "X";
        playerName = name;
    }
}