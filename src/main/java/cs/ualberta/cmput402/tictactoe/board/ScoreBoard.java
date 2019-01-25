package cs.ualberta.cmput402.tictactoe.board;

/**
 * ScoreBoard class which keeps track of how many games were won, lost, tied by each player and displays scores
 */
public class ScoreBoard {
    private int xWin,oWin,tie;

    public ScoreBoard() {
        xWin=0;
        oWin=0;
        tie=0;
    }

    //Score up points
    public void score(Board.Player player) {
        switch(player)
        {
            case X:
                xWin++;
                break;
            case O:
                oWin++;
                break;
            case NONE:
                tie++;
                break;
        }
    }

    //Print the current scoreboard
    public void printScoreBoard() {
        System.out.println("--------Score Board--------");
        System.out.println("Player | Win | Loss | Tie");
        System.out.println("---------------------------");
        System.out.printf("   X   |%3d  |%4d  |%3d ",xWin,oWin,tie);
        System.out.println();
        System.out.println("---------------------------");
        System.out.printf("   O   |%3d  |%4d  |%3d ",oWin,xWin,tie);
        System.out.println();
        System.out.println("---------------------------");
    }
}
