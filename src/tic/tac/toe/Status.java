
package tic.tac.toe;

import tic.tac.toe.TICTACTOE.Tile;

/*
 * @author Gaurav
 */
public class Status {
    // Vertical
    public boolean checkVertical(Tile[][] board){
        for(int i=0;i<3;i++){
            if(board[0][i].getTile().equals(board[1][i].getTile()) &&
                    board[1][i].getTile().equals(board[2][i].getTile()) &&
                    board[0][i].getTile().length()!=0)
                return true;
        }
        return false;
    }
    //Horizontal
    public boolean checkHorizontal(Tile[][] board){
        for(int i=0;i<3;i++){
            if(board[i][0].getTile().equals(board[i][1].getTile()) &&
                    board[i][1].getTile().equals(board[i][2].getTile()) &&
                    board[i][0].getTile().length()!=0)
                return true;
        }
        return false;
    }
    
    //Diagonal
     public boolean checkDiag(Tile[][] board){
        if(board[0][0].getTile().equals(board[1][1].getTile()) &&
               board[1][1].getTile().equals(board[2][2].getTile()) &&
                board[0][0].getTile().length()!=0)
            return true;
        
        if(board[2][0].getTile().equals(board[1][1].getTile()) &&
               board[1][1].getTile().equals(board[0][2].getTile()) &&
                board[0][2].getTile().length()!=0)
            return true;
        return false;
    }
}
