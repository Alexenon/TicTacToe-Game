package xenon;

import xenon.game.Board;
import xenon.game.Move;
import xenon.players.HumanPlayer;
import xenon.players.Player;

public class Main {

    /**
     * TODO: Add all this stuff in certain project
     *  Add flexible board n x n tiles
     * */
    public static void main(String[] args) {

        Board board = new Board();
        Player human = new HumanPlayer();
        Player opponent = Player.chooseOpponent();
        Move move = new Move();

        System.out.println(human + " vs " + opponent);

        while(board.isGameRunning()){

            board.printWhoMoves();
            move.moveByCurrentPlayer();

            board.printBoard();
            if(board.isGameRunning()) {
                Player.nextPlayer();
            }
        }
        System.out.println(board.getFinalMessage());
    }

}