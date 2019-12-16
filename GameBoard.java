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
        String[][] gameBoard = {{"   ", "|", "   ", "|", "   "},
                                {"---", "+", "---", "+", "---"},
                                {"   ", "|", "   ", "|", "   "},
                                {"---", "+", "---", "+", "---"},
                                {"   ", "|", "   ", "|", "   "}};
        int turn = 0;
        int index = 0 ;
        boolean boolValue = true;
        int[] posArray = new int[9];    // array help me to keep record of the position where the value has already been added                        

        // creating Instance players 
        Player Player1 = new Player1();
        Player Player2 = new Player2();

        // printing the board for now
        // for debugging
        // printBoard(gameBoard);

        while(boolValue){
            Scanner scanItem = new Scanner(System.in);

            // Assigns player1 and player 2 consecutively 
            Player currentPlayer = returnPlayer(Player1,Player2,turn);

            System.out.print("Enter the position of " + currentPlayer.toString() +  " for " + currentPlayer.playerName() + " : " );
            String pos = String.valueOf(scanItem.nextInt());

            if(enterInPosition(Integer.valueOf(pos),posArray)){
                if (Integer.valueOf(pos)<1 || Integer.valueOf(pos) >9){
                    System.out.println("Please Enter valid position (between 1 and 9 )! ");
                }else{
                    posArray[index] = Integer.valueOf(pos);
                    index++;
                }

                // increament turns here so that the player does not changes
                // prevents changing player if someone tries to enter in pre-occupied block  
                turn++;
                
                // used to put X or O in the associated giver block 
                playTic(pos, gameBoard, currentPlayer);
                printBoard(gameBoard);
                if (validateDiagonal(gameBoard, currentPlayer, Player1, Player2)){
                    System.out.println(currentPlayer.playerName() + " has won the game ");
                    boolValue = false;
                } else if (!validateEmpty(gameBoard)){
                    System.out.println("\nGood Try ! The Game Ended with no one actually winning ! ");
                    boolValue = false;
                }  
            }else{
                System.out.println("Already added a value here ! Please enter Value in other places !");
            }
        }
        // cannot be resolved here
        // if i put inside shows noSuchElementException
        //scanItem.close();
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
    // used switch to avoid errors 
    public static void playTic(String pos, String[][] gameBoard, Player currentPlayer){
        switch(Integer.valueOf(pos)){
            case 1:
                gameBoard[0][0] = " " + currentPlayer.toString() + " ";
                break;
            case 2:
                gameBoard[0][2] = " " + currentPlayer.toString() + " ";
                break;
            case 3:
                gameBoard[0][4] = " " + currentPlayer.toString() + " ";
                break;
            case 4:
                gameBoard[2][0] = " " + currentPlayer.toString() + " ";
                break;
            case 5:
                gameBoard[2][2] = " " + currentPlayer.toString() + " ";
                break;
            case 6:
                gameBoard[2][4] = " " + currentPlayer.toString() + " ";
                break;
            case 7:
                gameBoard[4][0] = " " + currentPlayer.toString() + " ";
                break;
            case 8:
                gameBoard[4][2] = " " + currentPlayer.toString() + " ";
                break;
            case 9:
                gameBoard[4][4] = " " + currentPlayer.toString() + " ";
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
        for (int index = 0 ; index < posArray.length ; index++){
            if(posArray[index] == (pos)){
                return false;
            }    
        }
        return true;
    }

    // Method that checks if the diagonals are same 
    // checks for both cases 
    private static boolean validateDiagonal(String[][] gameBoard, Player currentPlayer, Player Player1, Player Player2 ){
        if (gameBoard[0][0].equals(gameBoard[2][2]) && gameBoard[0][0].equals(gameBoard[4][4]) && (gameBoard[0][0].equals(Player1.toString()) || gameBoard[0][0].equals(Player2.toString()))){
            return true;
        }else if (gameBoard[4][0].equals(gameBoard[2][2]) && gameBoard[4][0].equals(gameBoard[0][4]) && (gameBoard[4][0].equals(Player1.toString()) || gameBoard[0][0].equals(Player2.toString()))){
            return true;
        }
        return false;
    }


    // checks if the tic tak Toe is full for not
    // returns false if it is full
    // keeps returning true if the blocks in the TIC TAC TOE are empty  
    private static boolean validateEmpty(String[][] gameBoard){
        for (int row = 0 ; row < 3 ; row++){
            for (int col = 0 ; col < gameBoard[row].length ; col++){
                if(gameBoard[row+2][col].equals("   ")){
                    return true;
                }
            }
        }
        return false;
    }

}