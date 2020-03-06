import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.*;
public class Square implements ActionListener
{
    private int pieceType;
    private int xCord;
    private int yCord;
    private int image;
    private int objectNum;
    public Square(JFrame map, int objectNum,int x,int y)
    {
        ImageIcon i;
        JButton b1 = new JButton();
        b1.addActionListener(this);
        this.objectNum = objectNum;
        if (objectNum==2)
        {
            i = new ImageIcon("LilyPad.png");
            b1.setIcon(i);
            
        }
        else if (objectNum==3)
        {
            i = new ImageIcon("GreenFrog.png");
        
            b1.setIcon(i);
           
            
        }
        else if (objectNum==4)
        {
            i = new ImageIcon("RedFrog.png");
            b1.setIcon(i);
           
            
        }
        else{
            i = new ImageIcon("Water.png");
            b1.setIcon(i);
          ;
        }
        map.add(b1);
        xCord = x;
        yCord = y;
        pieceType = objectNum;


    }
    public int getPiece()
    {
        return pieceType;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(objectNum == 4)
        System.out.println("4");

            
    }


}