import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
public class Square implements ActionListener
{
    private int xCord;
    private int yCord;
    private int objectNum;
    JButton b1 = new JButton();
    Pictures picLoader = new Pictures();
    public Square(JFrame map, int oNum,int x,int y)
    {
        b1.addActionListener(this);
        picLoader.setPicture(this,b1,oNum);
        map.add(b1);
        xCord = x;
        yCord = y;


    }
    public int getPiece()
    {
        return objectNum;
    }
    public void updatePieceNum(int x)
    {
        objectNum = x;
    }
    public int moveTo(Square tile)
    {
        return tile.getPiece();


    }

    public void actionPerformed(ActionEvent e)
    {
       if(objectNum == Board.numRedFrog)
       {
        picLoader.setPicture(this,b1,Board.numRedFrog2);
       }
       else if(objectNum == Board.numRedFrog2)
       {
        picLoader.setPicture(this,b1,Board.numRedFrog);
       }
       if(objectNum == Board.numGreenFrog)
       {
        picLoader.setPicture(this,b1,Board.numGreenFrog2);
       }
       else if(objectNum == Board.numGreenFrog2)
       {
        picLoader.setPicture(this,b1,Board.numGreenFrog);
       }

         
    }
    


}