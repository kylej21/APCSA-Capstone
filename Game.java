//Project by
//Matthew Khuu
//Kyle Johnson
//Vinny Kanigicherla
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int turn = 0, col, row;
        boolean win = false, win2 = false;
        Piece temp = new Empty();
        Piece temp2 = new Empty();
        Piece tempObject = new Empty();
        Piece [][] board = new Piece [6][7];
        for (int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                board[i][j] = tempObject;
            }
        }
        System.out.println("CONNECT 4");
        System.out.println("------------");
        System.out.println("This is Connect 4! This is a 2 player game with pieces X and O. To win the game,\n"
            + "a player has to align four pieces in any orientation (including vertical, horizontal, and diagonal). Have fun!\n");

        display(board);
        while((!win && !win2) && turn < 42)
        {

            if(!win && !win2)
            {
                turn++;
                System.out.print("Player X, place your piece (0 - 6): ");
                col = scan.nextInt();
                while (col < 0 || col >  6) {
                    System.out.print("Please try again and center a number in the range with space: ");
                    col = scan.nextInt();
                }
                temp = new X((turn + 1)/2,turn);
                row = place(board, temp, col);
                while (row == -1) {
                    System.out.println("Please enter a number of a column that is not full: ");
                    col = scan.nextInt();
                    while (col < 0 || col >  6) {
                        System.out.print("Please try again and center a number in the range with space: ");
                        col = scan.nextInt();
                    }
                    row = place(board, temp, col);
                }
                display(board);
                win = checkWin(board, row, col);
            }
            if(!win && !win2)
            {
                turn++;
                System.out.print("Player O, place your piece (0 - 6): ");
                col = scan.nextInt();
                while (col < 0 || col >  6) {
                    System.out.print("Please try again and center a number in the range with space: ");
                    col = scan.nextInt();
                }
                temp2 = new O((turn + 1)/2,turn);
                row = place(board, temp2, col);
                while (row == -1) {
                    System.out.println("Please enter a number of a column that is not full: ");
                    col = scan.nextInt();
                    while (col < 0 || col >  6) {
                        System.out.print("Please try again and center a number in the range with space: ");
                        col = scan.nextInt();
                    }
                    row = place(board, temp2, col);
                }
                display(board);
                win2 = checkWin(board, row, col);
            }
        }
        if (win)
            System.out.println("Player X won on turn " + temp.winningTurn() + " with Piece #" + ((X)temp).returnNumber() + "!");
        else if (win2)
            System.out.println("Player O won on turn " + temp2.winningTurn() + " with Piece #" + ((O)temp2).returnNumber() + "!");
        else
            System.out.println("Tie!");
    }
    
    public static boolean full(Piece[][] b, int col)
        {
            return (b[0][col].returnPiece().equals("-"));
        }
        
        
    public static void display (Piece[][] b)
    {
        for(Piece[] r : b)
        {
            for(Piece p : r)
                System.out.print(p.returnPiece() + "\t");
            System.out.println("\n");
        }
        for (int i = 0; i < 7; i++)
            System.out.print(i + "\t");
        System.out.println("");
    }  

    public static int place (Piece[][] b, Piece p, int col)
    {
        for (int r = 5; r >= 0; r--)
        {
            if (b[r][col].returnPiece().equals("-"))
            {
                b[r][col] = p;
                return r;
            }
        }

        return -1;
    }

    public static boolean checkWin(Piece[][] board, int r, int c) {
        int subtract;
        if (r < c)
            subtract = r;
        else 
            subtract = c;

        int count = 0;
        String type = board[r][c].returnPiece(); 
        //Row Check    
        for (int col = 0; col < 7; col++ ) {
            if  (board[r][col].returnPiece().equals(type)) 
            {
                count++;
                if (count == 4) 
                    return true;
            }
            else 
                count = 0;

        }
        count = 0;

        //Column Check
        for (int row = 0; row < 6; row++) {
            if  (board[row][c].returnPiece().equals(type)) 
            {
                count++;
                if (count == 4) 
                    return true;
            }
            else 
                count = 0;

        }

        count = 0;

        //Positive Diagonal Check
        for (int row = 5, col = c - subtract; row >= 0 && col < 7; row--, col++) {
            if  (board[row][col].returnPiece().equals(type)) 
            {
                count++;
                if (count == 4) 
                    return true;
            }
            else 
                count = 0;
        }
        count = 0;

        //Negative Diagonal Check

        for (int row = 0, col = c - subtract; row < 6 && col < 7; row++, col++) {
            if  (board[row][col].returnPiece().equals(type)) 
            {
                count++;
                if (count == 4) 
                    return true;
            }
            else 
                count = 0;

        }
        return false;
    }

}