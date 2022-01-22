package xenon.players;

import java.util.Scanner;

public abstract class Player {

    protected static int playerCount = 0;
    protected static int playerIndex = 0;
    private final Character playerCharacter;
    private static final Player[] playerArray = new Player[2];
    public static Player currentPlayer;


    public Player() {
        if(playerCount == 0){
            playerCharacter = 'X';
            currentPlayer = this;
        } else{
            playerCharacter = 'O';
        }

        if(playerCount > 2){
            try {
                throw new Exception("Can't be more than 2 players created");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        playerArray[playerCount] = this;
        playerCount++;
    }

    public Character getPlayerCharacter() {
        return this.playerCharacter;
    }

    public static void nextPlayer() {
        if(playerIndex == 0)
            playerIndex = 1;
        else
            playerIndex = 0;

        currentPlayer = playerArray[playerIndex];
    }

    public static Player chooseOpponent(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello choose your opponent: ");
        System.out.println("1. Against player");
        System.out.println("2. Against computer");
        int n = scan.nextInt();

        if(n<1 || n>2)
            throw new IllegalArgumentException("ERROR! DOESN'T EXIST SUCH OPTION");

        return n==1 ? new HumanPlayer() : new ComputerPlayer();
    }

    @Override
    public String toString() {
        return currentPlayer.toString();
    }

}