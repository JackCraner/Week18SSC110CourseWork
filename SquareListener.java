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
        else if ((arrayOfSquares[x][y].getPiece()<=1)&&(cXCord>-1))
        {
            arrayOfSquares[x][y].moveTo(arrayOfSquares[cXCord][cYCord]);
            cYCord = -1;
                
            cXCord = -1;
        }
        
        
    }

    
}