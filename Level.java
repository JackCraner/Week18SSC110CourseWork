import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        try
        {
        File levelList = new File("LevelList.txt");
        Scanner levelReader = new Scanner(levelList);
        int lineCounter = 1;
        while (levelReader.hasNextLine())
        {
            String levelData[] = levelReader.nextLine().split(",");
            if (lineCounter == x)
            {
                for (int i = 0; i<levelData.length;i++)
                {
                    boardLayout[Character.getNumericValue(levelData[i].charAt(0))][Character.getNumericValue(levelData[i].charAt(1))] = Character.getNumericValue(levelData[i].charAt(2));
                }
                
            }
            lineCounter++;
        }
        } catch (FileNotFoundException e)
        {
            System.out.println("Error");
        }


    }
    
    public int[][] getLevel()
    {
        return boardLayout;
    }



}