package xenon.game;

import xenon.players.ComputerPlayer;
import xenon.players.HumanPlayer;

import java.util.Scanner;

import static xenon.players.Player.currentPlayer;

public class Move extends Board {

    private int row;
    private int col;
    private static char computer, opponent;

    public Move() {
        computer = currentPlayer.getPlayerCharacter();
        opponent = (computer == 'X') ? 'O' : 'X';
    }

    /**
     * This method is called in main function,
     * it depends on which player's turn is now
     * */
    public void moveByCurrentPlayer(){
        if(currentPlayer instanceof HumanPlayer) {
            moveByAskingIndexes();
        }
        else{
            Move bestMove = Move.findBestMove();
            bestMove.move(bestMove.row, bestMove.col, currentPlayer.getPlayerCharacter());
        }
    }

    /**
     * @param input should be a number between 1 and 9
     * otherwise will throw an error
     * */
    public static Pair<Integer, Integer> inputToIndexes(int input) {
        if (input < 1 || input > 9)
            throw new IllegalArgumentException("ERROR, WRONG INPUT!");

        input = input - 1; // easier to perform calculations
        int firstIndex = input / 3;
        int secondIndex = input - firstIndex * 3;
        return new Pair<>(firstIndex, secondIndex);
    }

    /**
     * Move by asked indexes from user
     * */
    private void moveByAskingIndexes(){
        if(currentPlayer instanceof ComputerPlayer)
            throw new IllegalStateException("ERROR, THIS IS NOT A HUMAN!");

        // Ask player to introduce indexes and call method move
        Move playerMove = new Move();
        playerMove.askIndexes();
        move(playerMove.row, playerMove.col, currentPlayer.getPlayerCharacter());
    }

    /**
     * Asks the player for indexes and store them in variables
     * */
    private void askIndexes() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter indexes: ");
        System.out.print("row=");
        row = scan.nextInt();
        System.out.print("col=");
        col = scan.nextInt();
    }

    private void move(int x, int y, char sign){
        if(isPositionAvailable(x, y))
            board[x][y] = sign;
        else {
            printError("THIS POSITION IS ALREADY TAKEN!");
            moveByAskingIndexes();
        }
    }

    private static boolean isPositionAvailable(int x, int y){
        return !(board[x][y] == 'X' || board[x][y] == 'O');
    }

    private static Boolean isMovesLeft(Character[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (Character.isDigit(board[i][j]))
                    return true;
        return false;
    }

    /**
     * This is the evaluation function
     * */
    private static int evaluate(Character[][] b) {

        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++) {
            if (b[row][0] == b[row][1] &&
                    b[row][1] == b[row][2]) {
                if (b[row][0] == computer)
                    return +10;
                else if (b[row][0] == opponent)
                    return -10;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++) {
            if (b[0][col] == b[1][col] && b[1][col] == b[2][col]) {
                if (b[0][col] == computer)
                    return +10;

                else if (b[0][col] == opponent)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
            if (b[0][0] == computer)
                return +10;
            else if (b[0][0] == opponent)
                return -10;
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
            if (b[0][2] == computer)
                return +10;
            else if (b[0][2] == opponent)
                return -10;
        }

        // Else if none of them have won then return 0
        return 0;
    }

    /**
     * This is the minimax function.
     * It considers all the possible ways
     * the game can go and returns the value of the board
     */
    private static int minimax(Character[][] board, int depth, Boolean isMax) {

        int score = evaluate(board);
        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10)
            return score;

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -10)
            return score;

        // If there are no more moves and
        // no winner then it is a tie
        if (!isMovesLeft(board))
            return 0;

        // If this maximizer's move
        int best;
        if (isMax)
        {
            best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (Character.isDigit(board[i][j])) {
                        char temp = board[i][j];
                        // Make the move
                        board[i][j] = computer;
                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax(board,
                                depth + 1, false));

                        // Undo the move
                        board[i][j] = temp;
                    }
                }
            }
        }

        // If this minimizer's move
        else {

            best = 1000;
            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (Character.isDigit(board[i][j])) {
                        char temp = board[i][j];
                        // Make the move
                        board[i][j] = opponent;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, minimax(board,
                                depth + 1, true));

                        // Undo the move
                        board[i][j] = temp;
                    }
                }
            }
        }
        return best;
    }

    /**
     *  This function will return the best possible move for the computer
     */
    public static Move findBestMove() {

        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Check if cell is empty
                if (Character.isDigit(board[i][j])) {
                    // Make the move
                    char temp = board[i][j];
                    board[i][j] = computer;

                    // compute evaluation function for this
                    int moveVal = minimax(board, 0, false);

                    // Undo the move
                    board[i][j] = temp;

                    // Set the best row and col founded
                    if (moveVal > bestVal) {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }

}


