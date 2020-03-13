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
        else if (((arrayOfSquares[x][y].getPiece()<=1)&&(cXCord>-1)))
        {
            if (checkMove(x,y) ==1)
            {
            arrayOfSquares[x][y].moveTo(arrayOfSquares[cXCord][cYCord]);
            cYCord = -1;
                
            cXCord = -1;
            }
        }
    }
    public int checkMove(int x, int y)
    {
        //diagonal 
        int a;
        int b;
        if (x>cXCord)
        {
            a = 1;
        }
        else 
        {
            a = -1;
        }
        if (x>cYCord)
        {
            b = 1;
        }
        else 
        {
            b =-1;
        }

        if (arrayOfSquares[cXCord+a][cYCord+b].getPiece() == Board.numGreenFrog)
        {
            if (arrayOfSquares[x][y].getPiece() == Board.numLily)
            {
                return 1;
            }
        }
        return 0;
    }
    public failedMove()
    {
        
    }

    
}