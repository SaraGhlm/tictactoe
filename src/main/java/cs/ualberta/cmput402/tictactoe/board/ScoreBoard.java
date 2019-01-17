package cs.ualberta.cmput402.tictactoe.board;

public class ScoreBoard {
    private int X_win,X_loss,X_tie;
    private int O_win,O_loss,O_tie;

    public ScoreBoard()
    {
        X_win=0;
        X_loss=0;
        X_tie=0;
        O_win=0;
        O_loss=0;
        O_tie=0;
    }

    public void score(Board.Player player)
    {
        switch(player)
        {
            case X:
                X_win++;
                O_loss++;
                break;
            case O:
                O_win++;
                X_loss++;
                break;
            case NONE:
                X_tie++;
                O_tie++;
                break;
        }
    }

    public void printScoreBoard()
    {
        System.out.println("--------Score Board--------");
        System.out.println("Player | Win | Loss | Tie");
        System.out.println("---------------------------");
        System.out.printf("   X   |%3d  |%4d  |%3d ",X_win,X_loss,X_tie);
        System.out.println();
        System.out.println("---------------------------");
        System.out.printf("   O   |%3d  |%4d  |%3d ",O_win,O_loss,O_tie);
        System.out.println();
        System.out.println("---------------------------");
    }
}
