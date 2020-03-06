import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.*;
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
                        boardLayout[i][a] = 2;
                    }
                }
                else
                {
                    if (!((a%2) ==0))
                    {
                        boardLayout[i][a] = 2;
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
            boardLayout[0][0] = 3;
            boardLayout[0][2] = 4;
            boardLayout[0][4] = 3;
            boardLayout[2][2] = 3;
            boardLayout[3][1] = 3;
            boardLayout[3][3] = 3;
        }


    }
    
    public int[][] getLevel()
    {
        return boardLayout;
    }



}