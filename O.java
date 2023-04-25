public class O extends Piece
{
    private int piece;
    public O(int p, int turn)
    {
        super(turn);
        piece = p;
    }

    public String returnPiece()
    {
        return "O";
    }
    
    public int returnNumber()
    {
        return piece;
    }
}