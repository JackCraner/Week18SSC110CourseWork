import java.util.Stack;

/**
 * SquareListener handles all the checking of moves 
 * - checking legals moves
 * 
 * - initalising the movement of squares
 * 
 * - removing a frog when it is jumped over
 *
 */
public class SquareListener
{
    private boolean squareSelected = false; // boolean to represent if a square on the board currently highlighted
    private int cXCord = -1;        //used to store the last clicked frogs location
    private int cYCord = -1;
    private Square arrayOfSquares[][];  //used to store the array of squares which represent the board
    Stack<int[]> moveList = new Stack<int[]>();  //a stack of every move the player makes, used for the undo moves feature

    /**
     * This constructor helps fill the array with the squares
     * @param x the already established square array within board
     */
    public SquareListener(Square x[][])
    {
        arrayOfSquares = x;

    }
    /**
     * This subroutine is run when a square is pressed
     * the ActionListener on the square from within the square class is activated 
     * it calls a subroutine from within Board, which calls this class and this specific subroutine
     * @param x the x coordinate of the square (the x value within the array)
     * @param y the y coordinate of the square 
     * 
     */
    public void slSelectSquare(int x,int y)
    {
        if (arrayOfSquares[x][y].getPiece()>1) //if piece is a frog
        {
            arrayOfSquares[x][y].selectSquare(); //highlights the piece or unhighlights it
            if (((cXCord == x) && (cYCord == y))||(cXCord<0))
            {
                cYCord = -1;        //if they click the same piece, to unselect it
                cXCord = -1;        //reset the last clicked variables
            }   
            else
            {
                arrayOfSquares[cXCord][cYCord].selectSquare();  //otherwise unselect the previously selected square
               
            }
            cXCord = x; 
            cYCord = y;
        }
        else if (((arrayOfSquares[x][y].getPiece()==1)&&(cXCord>-1))) //if lilypad pressed with a frog location in memory
        {
            int middleX = ((x +cXCord)/2);  //location of middle frog which will be removed
            int middleY = ((y+cYCord)/2);
            arrayOfSquares[cXCord][cYCord].selectSquare();
            if (checkMove(middleX,middleY))     //checks the middle square contains a frog
            {
                int[] moveCompleted = {cXCord,cYCord,x,y}; //if the move is valid, stores the move in the stack
                moveList.push(moveCompleted);

                arrayOfSquares[cXCord][cYCord].moveTo(arrayOfSquares[x][y]);
                removeFrog(middleX,middleY);
                cYCord = -1;      
                cXCord = -1;
            }
            else
            {
                cXCord = -1;
                cYCord = -1;
            }
        }
    }
    /**
     * this function will check the validity of a move
     * @param x the newest square presseds X location
     * @param y the newest square presseds y location 
     * @return true if legal move or a false if an invalid move
     */
    public boolean checkMove(int x, int y)
    {
        if (arrayOfSquares[x][y].getPiece() == Board.numGreenFrog||arrayOfSquares[x][y].getPiece() == Board.numRedFrog)
        {
            return true;
        }
        return false;

    }
    /**
     * This subroutine is called when the player wants to undo there last move
     * the last move is popped off the stack 
     * the frogs are returned to previous location 
     */
    public void undoMove()
    {
        if (!(moveList.isEmpty()))
        {
            int[] move = moveList.pop();
            arrayOfSquares[move[2]][move[3]].moveTo(arrayOfSquares[move[0]][move[1]]);
            arrayOfSquares[(move[0]+move[2])/2][(move[1] + move[3])/2].updateSquare(2);
        } 
        else
        {
            System.out.println("no more moves");

        }
    
    }
    /**
     * This subroutine is used to remove the middle frog when it is jumped over
     * @param x the x location of the frog
     * @param y the y location of the frog
     */
    public void removeFrog(int x, int y)
    {
        arrayOfSquares[x][y].updateSquare(1, arrayOfSquares[x][y]);
    }
    /**
     * 
     * @return the number of moves within the stack
     */
    public int returnNumMoves()
    {
        return moveList.size();
    }

    
}