public class SquareListener
{
    private boolean squareSelected = false;
    private int cXCord = -1;
    private int cYCord = -1;
    private Square arrayOfSquares[][];

    public SquareListener(Square x[][])
    {
        arrayOfSquares = x;
    }
    public void slSelectSquare(int x,int y)
    {
        if (arrayOfSquares[x][y].getPiece()>1)
        {
            arrayOfSquares[x][y].selectSquare();
            if (((cXCord == x) && (cYCord == y))||(cXCord<0))
            {
                cYCord = -1;
                cXCord = -1;
            }   
            else
            {
                arrayOfSquares[cXCord][cYCord].selectSquare();
               
            }
            cXCord = x;
            cYCord = y;
        }
        else if (((arrayOfSquares[x][y].getPiece()==1)&&(cXCord>-1)))
        {
            int middleX = ((x +cXCord)/2);
            int middleY = ((y+cYCord)/2);
            if (checkMove(middleX,middleY) ==1)
            {
            arrayOfSquares[x][y].moveTo(arrayOfSquares[cXCord][cYCord]);
            removeFrog(middleX,middleY);
            cYCord = -1;      
            cXCord = -1;
            }
            else
            {
                failedMove();
            }
        }
    }
    public int checkMove(int x, int y)
    {
        if (arrayOfSquares[x][y].getPiece() == Board.numGreenFrog||arrayOfSquares[x][y].getPiece() == Board.numRedFrog)
        {
            return 1;
        }
        return 0;

    }
    public void failedMove()
    {
        arrayOfSquares[cXCord][cYCord].selectSquare();
        cXCord = -1;
        cYCord = -1;
    }
    public void removeFrog(int x, int y)
    {
        arrayOfSquares[x][y].updateSquare(1, arrayOfSquares[x][y]);
    }

    
}