public class X extends Piece
{
    private int piece;
    public X(int p, int turn)
    {
        super(turn);
        piece = p;
    }

    public String returnPiece()
    {
        return "X";
    }
    
    public int returnNumber()
    {
        return piece;
    }
}