    /*
@
Player2 Class
Player class used to return X as the weapon
@
 */



public class Player2 extends Player{
    //---------- Assigning variables -----------
    String weapon;
    String playerName = "";

    // Constructor class 
    public Player2(){
        weapon = "O";
        playerName = "Player 2";
    }

    // method to return weapon 
    public String toString(){
        return weapon;
    }


    // method to return the name of the Player
    public String playerName(){
        return "Player 2";
    }

    public Player2(String name){
        weapon = "O";
        playerName = name;
    }

}