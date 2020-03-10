import javax.swing.*;
public class Pictures
{
    private String[] pictureLocations = {"Water", "LilyPad", "GreenFrog", "RedFrog","GreenFrog2","RedFrog2"};
    
    public Pictures()
    {
    }
    public void setPicture(Square x, JButton y, int z)
    {
        ImageIcon i = new ImageIcon(pictureLocations[z] + ".png");
        y.setIcon(i);
        x.updatePieceNum(z);

    }
}