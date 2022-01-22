package xenon.game;

import static xenon.players.Player.currentPlayer;

public class Board {

    final int GRID_SIZE = 3;
    final String dashes = "_".repeat(10);

    static final Character[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    public void printWithColor(String message, Enum<Color> color){
        System.out.println(color + message + Color.RESET);
    }

    public void printError(String message){
        printWithColor(message, Color.RED);
    }

    public void printWhoMoves(){
        printWithColor(currentPlayer.toString()
                + " now is your turn:", Color.MAGENTA);
    }

    public void printBoard() {

        printWithColor(dashes, Color.YELLOW_BOLD_BRIGHT);

        for (int i = 0; i < GRID_SIZE; i++){
            for (int j = 0; j < GRID_SIZE; j++){

                if(board[i][j] == 'X')
                    System.out.print(Color.BLUE + board[i][j].toString() + Color.RESET);
                else if(board[i][j] == 'O')
                    System.out.print(Color.GREEN_BOLD + board[i][j].toString() + Color.RESET);
                else
                    System.out.print(board[i][j]);

                if(j != GRID_SIZE-1)
                    System.out.print(Color.YELLOW_BOLD_BRIGHT + " | " + Color.RESET);
            }
            System.out.println();
        }

        printWithColor(dashes, Color.YELLOW_BOLD_BRIGHT);
    }

    private boolean isWonByRow(){

        return (board[0][0] == board[0][1] && board[0][1] == board[0][2]) ||
                (board[1][0] == board[1][1] && board[1][1] == board[1][2]) ||
                (board[2][0] == board[2][1] && board[2][1] == board[2][2]);
    }

    private boolean isWonByColumn(){

        return (board[0][0] == board[1][0] && board[1][0] == board[2][0]) ||
                (board[0][1] == board[1][1] && board[1][1] == board[2][1]) ||
                (board[0][2] == board[1][2] && board[1][2] == board[2][2]);
    }

    private boolean isWonByDiagonal(){

        return (board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    private boolean isDraw(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if(Character.isDigit(board[i][j]))
                    return false;
            }
        }
        return true;
    }

    public boolean isGameRunning(){
        return !isDraw() &&
                !isWonByColumn() &&
                !isWonByRow() &&
                !isWonByDiagonal();
    }

    public String getFinalMessage(){
        return isDraw() ? "The game is draw!"
                : currentPlayer.toString() + " won the game!";
    }

}