package cs.ualberta.cmput402.tictactoe;

import cs.ualberta.cmput402.tictactoe.board.Board;
import cs.ualberta.cmput402.tictactoe.board.ScoreBoard;
import cs.ualberta.cmput402.tictactoe.board.Board.Player;
import cs.ualberta.cmput402.tictactoe.board.exceptions.InvalidMoveException;

import java.util.Scanner;

/**
 * Created by snadi on 2018-07-18.
 */
public class TicTacToeGame {

    private Board board;

    public TicTacToeGame(){
        board = new Board();
    }

    public void promptNextPlayer(){
        switch(board.getCurrentPlayer()){
            case X:
                System.out.println("It's player " + board.getSymbol(board.getCurrentPlayer()) + "'s turn. Please enter the coordinates of your next move as x,y: ");
                break;
            case O:
                System.out.println("It's player " + board.getSymbol(board.getCurrentPlayer()) + "'s turn. Please enter the coordinates of your next move as x,y: ");
                break;

        }
    }

    public void playGame(){
        Scanner keyboardScanner = new Scanner(System.in);
        board.initBoard();
        while (board.getWinner() == null){
            board.printBoard();
            promptNextPlayer();
            String line = keyboardScanner.nextLine();
            String input[] = line.split(",");
            try {
                board.playMove(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            } catch (InvalidMoveException e) {
                System.out.println("Invalid coordinates. Try again");
                promptNextPlayer();
            }
        }

        board.printBoard();

        if (board.getWinner() == Player.NONE)
            System.out.println("The game ended in a tie!");
        else
            System.out.println("Player " + board.getWinner() + " has won the game!");
    }

    public char prompt(){
        System.out.println("Do you want to play again? (Y/N)");
        Scanner keyboardScanner = new Scanner(System.in);
        String line = keyboardScanner.next();

        char answer = ' ';
        while (Character.isWhitespace(answer)){
            if(line.equals("Y")){
                answer = 'Y';
            }
            else if(line.equals("N")) {
                answer = 'N';
            }
            else {
                System.out.println("Invalid! Try again");
                line = keyboardScanner.next();
            }
        }
        return answer;
    }

    public void playMultipleGames(){
        ScoreBoard scoreBoard = new ScoreBoard();
        playGame();
        scoreBoard.score(board.getWinner());
        scoreBoard.printScoreBoard();
        char answer = prompt();
        while (answer == 'Y') {
            System.out.println("lets play again");
            playGame();
            scoreBoard.score(board.getWinner());
            scoreBoard.printScoreBoard();
            answer = prompt();
        }
        scoreBoard.printScoreBoard();
    }

    public static void main(String args[]){
        TicTacToeGame game = new TicTacToeGame();
        game.playMultipleGames();
    }
}
