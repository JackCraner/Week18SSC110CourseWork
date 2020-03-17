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
    JPanel playingBoard;
    Board boardArena;
    public Square(Board boardMap, JPanel map, int oNum,int x,int y)
    {
        b1.addActionListener(this);
        picLoader.setPicture(this,b1,oNum);
        playingBoard = map;
        playingBoard.add(b1);
        xCord = x;
        yCord = y;
        boardArena = boardMap;

    }
    public int getPiece()
    {
        return objectNum;
    }
    public void updatePieceNum(int x)
    {
        objectNum = x;
    }
    public void moveTo(Square tile)
    {
        tile.selectSquare();
        updateSquare(tile.getPiece(),this);
        updateSquare(Board.numLily,tile);
    }

    public void selectSquare()
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
    public void updateSquare(int x, Square tile)
    {
        picLoader.setPicture(tile,tile.getButton(),x);
    }
    public JButton getButton()
    {
        return b1;
    }
    public void actionPerformed(ActionEvent e)
    {
      boardArena.squareClick(xCord,yCord,objectNum);
         
    }
    


}