/*
@@
   Game Board class contains the main method 
    Contains other methods : 
        1.printBoard :  to print the game board on the terminal 
        2.playTic : Adds "X" or "O" at corresponding positions 
        3.returnPlayer : returns players, used to consectively switch between players
        4.enterInPosition : Prevents overwritting by the user
        5.validateDiagonals : Verifies if the the diagonal of the game matches and trues a boolean based on that 
        6.validateRows : Verifies if the the rows of the game matches and trues a boolean based on that
        7.validateCols : verifies if the the columns of the game matches and trues a boolean based on that
        8.validateEmpty : Verifies if the game board is full or not and returns boolean based on the situation
        9. printInitialMessage : printing nice user Experience messages when the game is started 
        10. printLastMessage : printing nice user experience exiting messages when the game is over 
        
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
        
        System.out.println("\n*****************************************************************************");
        System.out.println("\t\tWelcome to the TIC TAC TOE game  ");
        System.out.println("*****************************************************************************");
         
        printInitialMessage();

        // printing the board for now
        // for debugging
        // printBoard(gameBoard);

        Scanner scanItem = new Scanner(System.in);

        while(boolValue){

            // Assigns player1 and player 2 consecutively 
            Player currentPlayer = returnPlayer(Player1,Player2,turn);

            System.out.print("Enter the position of " + currentPlayer.toString() +  " for " + currentPlayer.playerName() + " : " );
            String pos = String.valueOf(scanItem.nextInt());

            if(enterInPosition(Integer.valueOf(pos),posArray)){
                if (Integer.valueOf(pos)<1 || Integer.valueOf(pos) >9){
                    System.out.println("Please Enter valid position (between 1 and 9) \n");
                }else{
                    posArray[index] = Integer.valueOf(pos);
                    index++;

                    // increament turns here so that the player does not changes
                    // placing here prevents changing player if someone tries to enter in pre-occupied block  
                    turn++;
                }
                
                // used to put X or O in the associated giver block and print it as the players enter their "X" or "O" 
                playTic(pos, gameBoard, currentPlayer);
                printBoard(gameBoard);
                
                /* 
                @@  if else conditions to check various possible winning or losing conditions 
                    1. validateDiagonals 
                    2. validateRows
                    3. validateCols 
                    4. validateEmpty
                    5. Else no one won !
                */
                if (validateDiagonal(gameBoard)){
                    System.out.println("\n"+currentPlayer.playerName() + " has won the game by making similar Diagonals ! ");
                    printLastMessage();
                    boolValue = false;
                }else if(validateRows(gameBoard)){
                    System.out.println("\n"+currentPlayer.playerName() + " has won the game by making similar Rows !");
                    printLastMessage();
                    boolValue = false;
                }else if(validateCols(gameBoard)){
                    System.out.println("\n"+currentPlayer.playerName() + " has won the game by making similar Column ! ");
                    printLastMessage();
                    boolValue = false;
                }else if (!validateEmpty(gameBoard)){
                    System.out.println("\nGood Try ! The Game Ended with no one actually winning ! ");
                    printLastMessage();
                    boolValue = false;
                }  
            }else{
                System.out.println("Already added a value here ! Please enter Value in other places !");
            }
        }

        // make scanner Object outside the loop to prevent exceptions
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
    private static boolean validateDiagonal(String[][] gameBoard ){
        if (gameBoard[0][0].equals(gameBoard[2][2]) && gameBoard[0][0].equals(gameBoard[4][4]) && (gameBoard[2][2].equals(" X ") || gameBoard[2][2].equals(" O "))){
            return true;
        }else if (gameBoard[4][0].equals(gameBoard[2][2]) && gameBoard[4][0].equals(gameBoard[0][4]) && (gameBoard[4][0].equals(" X ") || gameBoard[4][0].equals(" O "))){
            return true;
        }
        return false;
    }

    // method to check win situation for rows 
    private static boolean validateRows(String[][] gameBoard){
        for (int row = 0 ; row < 3 ; row++){
            for (int col = 0 ; col < 1 ; col++){
                if( (gameBoard[row][col].equals(" X ") || gameBoard[row][col].equals(" O ")) && gameBoard[row][0].equals(gameBoard[row][2]) && gameBoard[row][0].equals(gameBoard[row][4])  ){
                    return true;
                }
            }
        }
        return false;
    }

    // method to check win situation for cols 
    private static boolean validateCols(String[][] gameBoard){

        for (int row = 0 ; row < gameBoard.length ; row++){
            for (int col = 0 ; col < 1 ; col++){
                if( (gameBoard[row][col].equals(" X ") || gameBoard[row][col].equals(" O ")) && gameBoard[0][row].equals(gameBoard[2][row]) && gameBoard[0][row].equals(gameBoard[4][row])  ){
                    return true;
                }
            }
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

    //method to print the initial messages for the game
    private static void printInitialMessage(){
        String[][] sampleGameBoard = {{" 1 ", "|", " 2 ", "|", " 3 "},
                                {"---", "+", "---", "+", "---"},
                                {" 4 ", "|", " 5 ", "|", " 6 "},
                                {"---", "+", "---", "+", "---"},
                                {" 7 ", "|", " 8 ", "|", " 9 "} };
        System.out.println("The Rules for the Game are quite straight forward and easy !");
        System.out.println("The first person to make rows/columns/diagonals with similar signs wins !");
        System.out.println("The following tic toe tac with numbers defines the positions to enter either X or O ! \nMake sure to remember these and not mess it up ! ");
        System.out.println("*****************************************************************************\n");
        for(String rows[] : sampleGameBoard){
            for (String cols : rows){
                System.out.print(cols);
            }
            System.out.println();
        }
        System.out.println("\n*****************************************************************************");
    }


    private static void printLastMessage(){
        System.out.println("\n*****************************************************************************");
        System.out.print("\t\tThanks for playing the game ! See you soon !");
        System.out.println("\n*****************************************************************************");
    }

}