
public class Level
{
    private int[][] boardLayout = new int[5][5];
    public Level()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int a = 0; a <5; a++)
            {
                if ((i % 2) == 0)
                {
                    if ((a%2) == 0)
                    {
                        boardLayout[i][a] = Board.numLily;
                    }
                }
                else
                {
                    if (!((a%2) ==0))
                    {
                        boardLayout[i][a] = Board.numLily;
                    }
                } 
            }

        }


    }
    public Level(int x)
    {
        Level newLevel = new Level();
        boardLayout = newLevel.getLevel();
        if (x == 1)
        {
            boardLayout[4][0] = Board.numRedFrog;
            boardLayout[3][1] = Board.numGreenFrog;
        }
        if (x == 2)
        {
            boardLayout[4][4] = Board.numRedFrog;
            boardLayout[2][4] = Board.numGreenFrog;
        }
        if (x == 3)
        {
            boardLayout[2][2] = Board.numRedFrog;
            boardLayout[3][3] = Board.numGreenFrog;
        }
        if (x ==4)
        {
            boardLayout[4][0] = Board.numRedFrog;
            boardLayout[1][3] = Board.numGreenFrog;
            boardLayout[3][1] = Board.numGreenFrog;
        }
        if ( x == 5)
        {
            boardLayout[0][0] = Board.numRedFrog;
            boardLayout[2][0] = Board.numGreenFrog;
            boardLayout[4][2] = Board.numGreenFrog;
        }
        if (x ==6 )
        {
            boardLayout[2][4] = Board.numRedFrog;
            boardLayout[1][1] = Board.numGreenFrog;
            boardLayout[1][3] = Board.numGreenFrog;
            boardLayout[2][2] = Board.numGreenFrog;
        }
        if (x == 40)
        {
            boardLayout[0][0] = Board.numGreenFrog;
            boardLayout[0][2] = Board.numRedFrog;
            boardLayout[0][4] = Board.numGreenFrog;
            boardLayout[2][2] = Board.numGreenFrog;
            boardLayout[3][1] = Board.numGreenFrog;
            boardLayout[3][3] = Board.numGreenFrog;
        }


    }
    
    public int[][] getLevel()
    {
        return boardLayout;
    }



}