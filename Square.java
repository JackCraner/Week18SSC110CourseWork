import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.*;
/**
 * This Class controls the squares which encapsulates the JButtons used to represent the board
 * This class handles:
 * - creating squares, including defining the image they show
 * - detecting clicks on the squares
 * - the code for moving squares
 * 
 * To the person reading this, a lot of the "how" each function works is found within subclasses 
 * of Square such as SquareListener and Pictures
 */
public class Square implements ActionListener
{
    private int xCord; //cords of the square
    private int yCord;
    private int objectNum; //stores the integer value of what picture the square is storing
    JButton b1 = new JButton(); //the button that represents the physical form of the square 
    Pictures picLoader = new Pictures();
    JPanel playingBoard;
    Board boardArena;
    /**
     * This Constructor creates a square
     * @param boardMap the original board from which the square is called 
     * @param map the panel which the square will be placed on
     * @param oNum the object number which tells the create which image to represent
     * @param x the x position of the square
     * @param y the y position
     */
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
    /**
     * 
     * @return returns the current image integer
     */
    public int getPiece()
    {
        return objectNum;
    }
    /**
     * @param x updates the private int variable, used when the image of the square changes
     */
    public void updatePieceNum(int x)
    {
        objectNum = x;
    }
    /**
     * This subroutine is used to move squares
     * @param tile the previous square clicked 
     */
    public void moveTo(Square tile)
    {
        updateSquare(getPiece(),tile);
        updateSquare(Board.numLily,this);
    }
    /**
     * This subroutine is used when a user clicks a square
     * it converts the picture on the square between the highlighted and unhighlighted version
     */
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
    /**
     * this subroutine is used to update the image of a square
     * @param x  the number of the new piece the square has to display
     * @param tile  the square we are changing
     */
    public void updateSquare(int x, Square tile)
    {
        picLoader.setPicture(tile,tile.getButton(),x);
    }
    /**
     * same as the subroutine above, except this is used when its this square we are changing
     * @param x the number of the new piece the square has to display
     */
    public void updateSquare(int x)
    {
        picLoader.setPicture(this,b1,x);
    }
    /**
     * 
     * @return the Jbutton that represents the Square
     */
    public JButton getButton()
    {
        return b1;
    }
    /**
     * when the square is clicked, calls a function from board
     */
    public void actionPerformed(ActionEvent e)
    {
      boardArena.squareClick(xCord,yCord);
         
    }
    


}