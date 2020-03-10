import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
public class Board
{
    public static int numWater = 0;
    public static int numLily = 1;
    public static int numGreenFrog = 2;
    public static int numRedFrog = 3;
    public static int numGreenFrog2 = 4;
    public static int numRedFrog2 = 5;

    public Board(int x, int y)
    {
        JFrame gamemap = new JFrame();
        gamemap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gamemap.setSize(x,y);
        gamemap.setTitle("Hooper Game");

        GridLayout newLayout = new GridLayout(5,5);
        gamemap.setLayout(newLayout);

        Square arrayOfSquares[][] = new Square[5][5];
        Level newLevel = new Level(1);
        int[][] boardLayout = newLevel.getLevel();
        for (int i = 4; i >=0;i--)
        {
            for (int a =0; a < 5; a++)
            {
                arrayOfSquares[i][a] = new Square(gamemap,boardLayout[i][a],i,a);
            }
        }
        gamemap.setVisible(true);
 
    }



}