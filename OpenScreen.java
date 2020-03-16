import javax.swing.JFrame;

import javafx.scene.layout.GridPaneBuilder;
import sun.awt.IconInfo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
public class OpenScreen implements ActionListener
{
    JFrame screen = new JFrame();
    
    JLabel messagebox = new JLabel("Enter Level Number: ");
    JTextField inputbox = new JTextField();
    JButton continueB = new JButton("Continue");
    JButton enter = new JButton("Enter");
    JButton exit = new JButton("Exit");
    Board originalBoard;
    
    private int levelNum;
    private boolean levelNumSuccess = false;
    public OpenScreen(int x, int y)
    {

        screen.setSize(x,y);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setTitle("Hooper Game");
        enter.addActionListener(this);
        continueB.addActionListener(this);
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
        display.add(continueB);
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
    public OpenScreen(int x, int y,Board a, int b)
    {
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        enter.addActionListener(this);
        exit.addActionListener(this);
        
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
        screen.add(endgameMessage); 
        screen.add(messagebox);
        screen.add(inputbox);
        screen.add(enter);
        screen.add(exit);

        GridLayout newLayout = new GridLayout(5,1);
        screen.setLayout(newLayout);

        screen.setVisible(true);
        originalBoard = a;
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == enter)
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
        if (e.getSource() == continueB)
        {
            if (levelNumSuccess)
            {
            Board map = new Board(750,750,levelNum);
            screen.dispose();
            }
        }
        if (e.getSource() == exit)
        {
            originalBoard.closeBoard();
            screen.dispose();
        }
		
    }
    
}