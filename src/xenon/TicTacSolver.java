package xenon;

import static xenon.Player.currentPlayer;

public class TicTacSolver {

    /**
     * TODO: Add all this stuff in certain project
     *  Add flexible board n x n tiles
     *
     * Optimize: check out the algorithm
     *  when 2 bots are playing against each other
     *
     * FIX: Final message works wrong
     *  the method nextPlayer is called always
     *
     * CLEAN: Clean the code in Main method
     *  - Move class
     *  - Board class
     * */
    public static void main(String[] args) {

        Board board = new Board();
        Player human = new HumanPlayer();
        Player opponent = Player.chooseOpponent();
        Move move = new Move();

        System.out.println(human + " vs " + opponent);

        while(!board.gameOver()){

            board.printWhoMoves();

            if(currentPlayer instanceof HumanPlayer) {
                move.moveAskingIndexes();
            }
            else{
                Move bestMove = Move.findBestMove();
                bestMove.move(bestMove.row, bestMove.col, currentPlayer.getPlayerCharacter());
            }

            board.printBoard();
            if(!board.gameOver())
                Player.nextPlayer();
        }

        System.out.println(board.getFinalMessage());
    }

}