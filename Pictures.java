import javax.swing.*;
/**
 * This class is used by the square class to update and change the photos of squares
 * 
 * This Class does:
 * -holds and stores the locations of all the images used by the game
 * -will update the square and update his pieceNumber
 */
public class Pictures
{
    private String[] pictureLocations = {"Water", "LilyPad", "GreenFrog", "RedFrog","GreenFrog2","RedFrog2"};
    
    public Pictures()
    {
    }
    /**
     * Updates the squares image
     * @param x the square object
     * @param y the button which the square is represented by 
     * @param z the number of the number piece
     */
    public void setPicture(Square x, JButton y, int z)
    {
        ImageIcon i = new ImageIcon(pictureLocations[z] + ".png");
        y.setIcon(i);
        x.updatePieceNum(z);

    }
}