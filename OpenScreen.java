import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
public class OpenScreen implements ActionListener
{
    JFrame display = new JFrame();
    JLabel messagebox = new JLabel("Enter Level Number: ");
    JTextField inputbox = new JTextField();
    JButton enter = new JButton("Continue");
    JButton exit = new JButton("Exit");
    Board originalBoard;
    public OpenScreen(int x, int y)
    {
        
        enter.addActionListener(this);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setSize(x,y);
        display.setTitle("Hooper Game");
        display.add(messagebox);
        display.add(inputbox);
        display.add(enter);

        GridLayout newLayout = new GridLayout(3,1);
        display.setLayout(newLayout);

        display.setVisible(true);
    }
    public OpenScreen(int x, int y,Board a, int b)
    {
        enter.addActionListener(this);
        exit.addActionListener(this);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setSize(x,y);
        display.setTitle("Hooper Game");
        JLabel endgameMessage;
        if (b==1)
        {
            endgameMessage = new JLabel("You Won");
        }
        else
        {
            endgameMessage = new JLabel("You Lost");
        }
        display.add(endgameMessage); 
        display.add(messagebox);
        display.add(inputbox);
        display.add(enter);
        display.add(exit);

        GridLayout newLayout = new GridLayout(5,1);
        display.setLayout(newLayout);

        display.setVisible(true);
        originalBoard = a;
    }
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == enter)
        {
            Board map = new Board(750,750,Integer.parseInt(inputbox.getText()));
            if (Integer.parseInt(inputbox.getText()) == 1)
            {
            System.out.println(Integer.parseInt(inputbox.getText()));
            }
            display.dispose();
        }
        if (e.getSource() == exit)
        {
            originalBoard.closeBoard();
            display.dispose();
        }
		
    }
}