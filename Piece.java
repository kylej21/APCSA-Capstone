public class Piece
{
    private int turn;
    public Piece(int t)
    {
        turn = t;
    }

    public int winningTurn()
    {
        return turn;
    }

    public String returnPiece()
    {
        return "";
    }
    
    public int returnNumber()
    {
        return 0;
    }
}
