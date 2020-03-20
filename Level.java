import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is used to generate and read the level data to feed to the board
 */
public class Level
{

    private int[][] boardLayout = new int[5][5]; // an integer array to store the corresponding integer number of pieces to represent the board
   
    /**
     * default constructor, uses loops to generate the default board
     * of water and lily pads and there positions are standardized 
     */
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
    /**
     * this Level constructor will generate the locations within the array of the frogs
     * @param x which is the level number between 1 and 40 
     * calls the default constructor to generate the water and lilypads
     * reads the levels textfile and breaks down the data of the specific line
     * stores the corresponding numbers in the corresponding array locations
     */
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
    /**
     * this function is called to return the BoardLayout
     * @return the 2d array which stores the locations of all the pieces on the board
     */
    public int[][] getLevel()
    {
        return boardLayout;
    }



}