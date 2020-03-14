import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
public class EndScreen implements ActionListener
{
    Board mainBoard;
    JFrame winDisplay = new JFrame();
    JButton returnButton;
    JButton exitButton = new JButton("Exit");
    public EndScreen(int x, int y,Board a, int b)
    {
        
        winDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winDisplay.setSize(x,y);
        winDisplay.setTitle("Hooper Game");

        GridLayout newLayout = new GridLayout(1,2);
        winDisplay.setLayout(newLayout);
        
        if (b == 1)
        {
            returnButton = new JButton("You Won, Play Again?");
        }
        else
        {
            returnButton = new JButton("You Lost, Play Again?");
        }
        exitButton.addActionListener(this);
        returnButton.addActionListener(this);
        winDisplay.add(returnButton);
        winDisplay.add(exitButton);
        winDisplay.setVisible(true);
        mainBoard = a;
        
    }
    public void actionPerformed(ActionEvent e) 
    {
        mainBoard.closeBoard();
        winDisplay.dispose();
        if (e.getSource() == returnButton)
        {
            Board newGame = new Board(750,750);
        }   
    }
}