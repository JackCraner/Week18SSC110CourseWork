import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.*;
public class Board
{
    private static int numWater = 1;
    private static int numLily = 2;
    private static int numGreenFrog = 3;
    private static int numRedFrog = 4;

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