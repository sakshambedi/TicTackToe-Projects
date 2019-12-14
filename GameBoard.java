/*
@@
   Game Board class contains the main method 

   parent class does nothing 
   SubClass : 
            1. Player One - X
            2. Player Two - O

    Copyright : Saksham Bedi
@@
*/

// ----------------------Importing Libraries ------------------------------
import java.util.Scanner;


public class GameBoard{

    // main mehtod for the class
    public static void main(String[] args){
        // ------------------ Assigning variables --------------==
        String[][] gameBoard = {{"  ", "|", "  ", "|", "  "},
                                {"--", "+", "--", "+", "--"},
                                {"  ", "|", "  ", "|", "  "},
                                {"--", "+", "--", "+", "--"},
                                {"  ", "|", "  ", "|", "  "}};
        int turn = 0;
        int[] posArray = new int[9];    // array help me to keep record of the position where the value has already been added
        Scanner scanItem = new Scanner(System.in);                        

        // creating Instance players 
        Player Player1 = new Player1();
        Player Player2 = new Player2();


        // printing the board for now
        // for debugging
        // printBoard(gameBoard);

        // Assigns player1 and player 2 consecutively 
        Player currentPlayer = returnPlayer(Player1,Player2,turn);
        turn++;

        System.out.print("Enter the position of " + currentPlayer.toString() +  " for " + currentPlayer.playerName() + " : " );
        String pos = String.valueOf(scanItem.nextInt());
        
        if(enterInPosition(Integer.valueOf(pos),posArray)){
            playTic(pos, gameBoard, currentPlayer);
            printBoard(gameBoard);
            if (gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0]== gameBoard[4][4] && (gameBoard[0][0] == Player1.toString() || gameBoard[0][0] == Player2.toString())){
                System.out.println(currentPlayer.playerName() + " has won the game ");
            }else if (gameBoard[4][0] == gameBoard[2][2] && gameBoard[4][0]== gameBoard[0][4] && (gameBoard[4][0] == Player1.toString() || gameBoard[0][0] == Player2.toString())){
                System.out.println(currentPlayer.playerName() + " has won the game ");
            }else if (gameBoard[])
        }else{
            System.out.println("Already added a value here ! Please enter Value in other places !");
        }

        // closing scanner object 
        scanItem.close();
        
    }


    // Method to print the Tic Tak Toe 
    public static void printBoard(String[][] gameBoard){
        for(String[] row : gameBoard){
            for (String eachCharac : row){
                System.out.print(eachCharac);
            }
            System.out.println();
        }
    }

    // Method to edit and manipulate the grid 
    // based upon the position recieved as a parameter 
    public static void playTic(String pos, String[][] gameBoard, Player currentPlayer){
        switch(Integer.valueOf(pos)){
            case 1:
                gameBoard[0][0] = currentPlayer.toString() + " ";
                break;
            case 2:
                gameBoard[0][2] = currentPlayer.toString() + " ";
                break;
            case 3:
                gameBoard[0][4] = currentPlayer.toString() + " ";
                break;
            case 4:
                gameBoard[2][0] = currentPlayer.toString() + " ";
                break;
            case 5:
                gameBoard[2][2] = currentPlayer.toString() + " ";
                break;
            case 6:
                gameBoard[2][4] = currentPlayer.toString() + " ";
                break;
            case 7:
                gameBoard[4][0] = currentPlayer.toString() + " ";
                break;
            case 8:
                gameBoard[4][2] = currentPlayer.toString() + " ";
                break;
            case 9:
                gameBoard[4][4] = currentPlayer.toString() + " ";
                break;        
        }
    }

    // method to return the current Playertype
    private static Player returnPlayer(Player Player1, Player Player2, int turn){
        Player currentPlayer;
        if(turn%2==0){
            currentPlayer = Player1;
        }else{
            currentPlayer = Player2;
        }
        return currentPlayer; 
    } 

    //  keeps record the positions where the value has added a value 
    //  prevents over written values 
    private static boolean enterInPosition(int pos,int[] posArray){
        for (int index : posArray){
            if(posArray[index] == (pos)){
                return false;
            }    
        }
        return true;
    }

}