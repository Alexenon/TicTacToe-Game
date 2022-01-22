package xenon;

public class HumanPlayer extends Player {

    private static int count = 0;

    public HumanPlayer(){
        super();
        count++;
    }

    private String countToString(){
        return playerIndex == 0 ? "One" : "Two";
    }

    @Override
    public String toString(){
        return count==1 ? "Human Player"
                : "Player " + countToString();
    }



}