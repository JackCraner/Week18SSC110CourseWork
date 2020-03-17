import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.*;
public class Board implements ActionListener
{
    public static int numWater = 0;
    public static int numLily = 1;
    public static int numGreenFrog = 2;
    public static int numRedFrog = 3;
    public static int numGreenFrog2 = 4;
    public static int numRedFrog2 = 5;

    Square arrayOfSquares[][] = new Square[5][5];
    JFrame gamemap = new JFrame();
    JPanel buttonHolder = new JPanel();
    SquareListener squareChecker;

    JButton exit;
    JButton save;
    JButton undo;

    public Board(int x, int y, int a)
    {
       
        gamemap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gamemap.setSize(x,y);
        gamemap.setTitle("Hooper Game");

        

        Level newLevel = new Level(a);
        int[][] boardLayout = newLevel.getLevel();
        for (int i = 4; i >=0;i--)
        {
            for (int c =0; c < 5; c++)
            {
                arrayOfSquares[i][c] = new Square(this,buttonHolder,boardLayout[i][c],i,c);
            }
        }
        GridLayout newLayout = new GridLayout(5,5);
        buttonHolder.setLayout(newLayout);
        squareChecker = new SquareListener(arrayOfSquares);
        JPanel optionHolder = new JPanel();
        exit = new JButton("Exit");
        undo = new JButton("Undo");
        save = new JButton("Save");
        GridLayout newLayout2 = new GridLayout(3,1);
        optionHolder.add(undo);
        optionHolder.add(save);
        optionHolder.add(exit);
        optionHolder.setLayout(newLayout2);
        gamemap.add(buttonHolder, BorderLayout.CENTER);
        gamemap.add(optionHolder, BorderLayout.EAST);
        gamemap.setVisible(true);
 
    }

    public void squareClick(int x, int y, int objectNum)
    {   
       squareChecker.slSelectSquare(x,y);
       if (checkWin() == 1)
       {
            System.out.println("Finished");   
            OpenScreen winDisplay = new OpenScreen(400, 300, this,1);
       }
       else if (checkWin() == 2)
       {
            System.out.println("You Lost"); 
            OpenScreen loseDisplay = new OpenScreen(400, 300, this,2); 
           
       }
    }

    public int checkWin()
    {
        boolean won = true;
        boolean lost = true;
        for (int a=0;a<5;a++)
        {
            for (int b=0;b<5;b++)
            {
                if (arrayOfSquares[a][b].getPiece() == numGreenFrog|| arrayOfSquares[a][b].getPiece() == numGreenFrog2)
                {
                    won = false;
                }
                if (arrayOfSquares[a][b].getPiece() == numRedFrog||arrayOfSquares[a][b].getPiece() == numRedFrog2)
                {
                    lost = false;
                }
            }
        }
        if (lost)
        {
            return 2;
        }
        if (won)
        {
            return 1;
        }
        return 0;
    }
    public void closeBoard()
    {
        gamemap.dispose();
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == exit)
        {
            gamemap.dispose();
        }        
        if (e.getSource() == undo)
        {
            
        }
    }

}