import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.Timer;
import java.awt.GridLayout;
import java.awt.event.*;
public class Board implements ActionListener  //the implements allows for the JButtons to be clicked
{
    public static int numWater = 0;  //public static variables which 
    public static int numLily = 1;      //store the corresponding integer value
    public static int numGreenFrog = 2; //for each of the different pieces.
    public static int numRedFrog = 3;   //They are public as they are used through-out other classes
    public static int numGreenFrog2 = 4;//to keep the numbers consistent and also make the code more 
    public static int numRedFrog2 = 5;  //easily readable.

    private boolean boardRunning = true;        //is swapped to false when the board is finished
    Square arrayOfSquares[][] = new Square[5][5];   //holds an array of the squares which make up the frog game board
    JFrame gamemap = new JFrame();  //the screen
    JPanel buttonHolder = new JPanel(); //the panel which holds the squares
    SquareListener squareChecker;   //this is a class which manages all the clicking of the squares

    JButton exit; //creating buttons 
    JButton undo; 

    TimerJob timerTaskJob;  //creates the class which runs the code when the timer reaches it schedule
    Timer boardTimer;       //creates the timer
    /**
     * Construdtor used to create a board to play on
     * @param x width of the board
     * @param y height of the board
     * @param a the level number of the board (defines the level to be played)
     */
    public Board(int x, int y, int a)
    {
       
        gamemap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gamemap.setSize(x,y);
        gamemap.setTitle("Hooper Game");

        

        Level newLevel = new Level(a);      //creates an object of the level class, which has the functions to generate a Level layout
        int[][] boardLayout = newLevel.getLevel(); //fills the array up with the layout of the level. the integers in the array correspond to pieces
        for (int i = 4; i >=0;i--)      //loops through all the positions of the board
        {
            for (int c =0; c < 5; c++)
            {
                //each square is passed: the board, the panel the square is within, the number of the piece it shows and its X and Y coordinates
                arrayOfSquares[i][c] = new Square(this,buttonHolder,boardLayout[i][c],i,c); //fills an array of squares to represent the board
            }
        }
        GridLayout newLayout = new GridLayout(5,5); //creates a gridlayout
        buttonHolder.setLayout(newLayout);
        squareChecker = new SquareListener(arrayOfSquares); //keeps track of the squares if they clicked
        JPanel optionHolder = new JPanel();
        JLabel timerLabel = new JLabel();

        boardTimer = new Timer();
        
        timerTaskJob = new TimerJob(); 

        timerTaskJob.getObjects(timerLabel);
        boardTimer.schedule(timerTaskJob, 100,100);

        
        exit = new JButton("Exit");
        undo = new JButton("Undo");
        undo.addActionListener(this);
        exit.addActionListener(this);
        GridLayout newLayout2 = new GridLayout(4,1);
        optionHolder.add(timerLabel);
        optionHolder.add(undo);
        optionHolder.add(exit);
        optionHolder.setLayout(newLayout2);
        gamemap.add(buttonHolder, BorderLayout.CENTER);
        gamemap.add(optionHolder, BorderLayout.EAST);
        gamemap.setVisible(true);
 
    }
    /**
     * This subroutine is called when a square is pressed
     * @param x the x value of the square which is clicked
     * @param y the y value of the square which is clicked
     */
    public void squareClick(int x, int y)
    {  
        if (boardRunning)
        {
        squareChecker.slSelectSquare(x,y);
        if (checkWin() == 1)
        {
            System.out.println("Finished");   
            OpenScreen winDisplay = new OpenScreen(400, 300, this,1,timerTaskJob.getTime(),squareChecker.returnNumMoves());
            endBoardUsage();
        }
        else if (checkWin() == 2)
            {
            System.out.println("You Lost"); 
            OpenScreen loseDisplay = new OpenScreen(400, 300, this,2, timerTaskJob.getTime(),squareChecker.returnNumMoves()); 
            endBoardUsage();
            }
        }
    }
    /**
     * checks if the game has be won or lost
     * @return a 1 if the game is won (no green frogs left) and will return a 2 if the game is lost (no red frog)
     */
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
    /**
     * a function to close the JFrame which is the board
     */
    public void closeBoard()
    {
        gamemap.dispose();
    }
    /**
     * corresponds to the actionListeners on the option buttons
     * will exit the game if the exit button is pressed 
     * will undo the last move if that button is pressed
     */
    public void actionPerformed(ActionEvent e) 
    {
        if (boardRunning)
        {
            if (e.getSource() == exit)
            {
                gamemap.dispose();
            }        
            if (e.getSource() == undo)
            {
                squareChecker.undoMove();
            }
        }
    }
    /**
     * called when the game is finished
     * cancels the timer used to count how long the player took
     * changes a boolean to false to signal the end of the game
     */
    public void endBoardUsage()
    {
        boardRunning = false;
        boardTimer.cancel();
    }

}