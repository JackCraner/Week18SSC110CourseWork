
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