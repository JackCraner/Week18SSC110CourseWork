import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
/**
 * This Class:
 * - creates a frame for the introduction (before the board) used to select a level
 * - creates a frame for the outro (when the game is lost or won)
 * 
 */
public class OpenScreen implements ActionListener
{
    //initalised a bunch of objects used to make up the different screens
    JFrame screen = new JFrame();
    
    JLabel messagebox = new JLabel("Enter Level Number: ");
    JTextField inputbox = new JTextField();
    JButton continueB = new JButton("Continue");
    JButton continueB1 = new JButton("Continue");
    JButton enter = new JButton("Enter");
    JButton exit = new JButton("Exit");
    Board originalBoard;
    
    private int levelNum;
    private boolean levelNumSuccess = false;
    /**
     * This Constructor creates the intro screen
     * @param x width of the screen
     * @param y height of the screen
     */
    public OpenScreen(int x, int y)
    {

        screen.setSize(x,y);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setTitle("Hooper Game");
        enter.addActionListener(this);
        continueB1.addActionListener(this);
        JPanel display = new JPanel();
        JLabel titleMessage = new JLabel("Welcome to Hoppers");
        titleMessage.setFont(new Font("Impact", Font.PLAIN,80));
        JPanel inputArea = new JPanel();
        inputArea.add(messagebox);
        inputArea.add(inputbox);
        inputArea.add(enter);

        GridLayout newLayout = new GridLayout(1,3);
        inputArea.setLayout(newLayout);

        display.add(inputArea);
        display.add(continueB1);
        GridLayout newLayout2 = new GridLayout(2,1);
        display.setLayout(newLayout2);

        JPanel overlay = new JPanel();
        ImageIcon titleImage = new ImageIcon("GreenFrog.png");
        JLabel titleimageL = new JLabel(titleImage);
        overlay.add(display);
        overlay.add(titleimageL);
        GridLayout newLayout3 = new GridLayout(1,2);
        overlay.setLayout(newLayout3);

        JPanel overlay2 = new JPanel();

        overlay2.add(titleMessage,BorderLayout.NORTH);
        overlay2.add(overlay);

        screen.add(overlay2);

        screen.setVisible(true);
    }
    /**
     * creates the outro screen
     * @param x width
     * @param y height
     * @param a the previous board
     * @param b whether the game was won or lost
     * @param timeTakenNumber the time taken to finish the game
     * @param movesDoneNumber the number of moves
     */
    public OpenScreen(int x, int y,Board a, int b, double timeTakenNumber, int movesDoneNumber)
    {
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        enter.addActionListener(this);
        continueB.addActionListener(this);
        exit.addActionListener(this);
        JPanel optionPanel = new JPanel();

        screen.setSize(x,y);
        screen.setTitle("Hooper Game");
        JLabel endgameMessage;
        if (b==1)
        {
            endgameMessage = new JLabel("You Won", SwingConstants.CENTER);
            
        }
        else
        {
            endgameMessage = new JLabel("You Lost",SwingConstants.CENTER);
            
        }
        endgameMessage.setFont(new Font("Impact", Font.PLAIN,30));
        optionPanel.add(endgameMessage); 
        optionPanel.add(messagebox);
        JPanel enterbox = new JPanel();
        enterbox.add(inputbox);
        enterbox.add(enter);
        GridLayout enterboxLayout = new GridLayout(1,2);
        enterbox.setLayout(enterboxLayout);
        optionPanel.add(enterbox);
        optionPanel.add(continueB);
        optionPanel.add(exit);

        GridLayout newLayout = new GridLayout(6,1);
        optionPanel.setLayout(newLayout);

        JPanel gameResults = new JPanel();
        JLabel timeTaken = new JLabel("Time Taken:");
        timeTaken.setFont(new Font("Impact", Font.PLAIN,30));
        JLabel timeTaken2 = new JLabel(timeTakenNumber + " Seconds",SwingConstants.CENTER);
        timeTaken2.setFont(new Font("Impact", Font.PLAIN,15));
        JLabel movesDone = new JLabel("Total Moves:");
        movesDone.setFont(new Font("Impact", Font.PLAIN,30));
        JLabel movesDone2 = new JLabel("" + movesDoneNumber,SwingConstants.CENTER);
        movesDone2.setFont(new Font("Impact", Font.PLAIN,15));
        gameResults.add(timeTaken);
        gameResults.add(timeTaken2);
        gameResults.add(movesDone);
        gameResults.add(movesDone2);
        GridLayout newLayout2 = new GridLayout(4,1);
        gameResults.setLayout(newLayout2);

        screen.add(optionPanel, BorderLayout.CENTER);
        screen.add(gameResults, BorderLayout.EAST);
        screen.setVisible(true);
        originalBoard = a;
    }
    /**
     * When a button of the form is clicked 
     */
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == enter) //inputting level number
        {
            JFrame frame = new JFrame();
            frame.setSize(300, 300);
            int inputNum = Math.round(Integer.parseInt(inputbox.getText()));
            if (inputNum > 0 && inputNum <41)
            {
                levelNum = inputNum;
                levelNumSuccess = true;
                JOptionPane.showMessageDialog(frame,"Level Number Successful!");
            }
            else
            {
                levelNumSuccess = false;
                inputbox.setText("");
                JOptionPane.showMessageDialog(frame, "Input Number Wasnt Valid, Try a number between 1 and 40");
            }
        }
        if (e.getSource() == continueB) //when the level number is successful and creating a corresponding board
        {
            if (levelNumSuccess)
            {
            originalBoard.closeBoard();
            Board map = new Board(750,750,levelNum);
            screen.dispose();
            
            }
        }
        if (e.getSource() == continueB1)
        {
            Board map = new Board(750,750,levelNum);
            screen.dispose();
        }
        if (e.getSource() == exit) //exits the board
        {
            originalBoard.closeBoard();
            screen.dispose();
        }
		
    }
    
}