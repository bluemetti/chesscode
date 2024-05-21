package main;

import pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input extends MouseAdapter {

    Board board;

    public Input(Board board){
        this.board = board;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX()/ board.tSize;
        int line = e.getY()/ board.tSize;

        Piece pieceXY = board.getPiece(col, line);
        if (pieceXY!= null){
            board.selPiece = pieceXY;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (board.selPiece!= null){
            board.selPiece.xp = e.getX() - board.tSize/2; //arrasta a peça (- board.tSize/2 serve para centralizar no mouse)
            board.selPiece.yp = e.getY()- board.tSize/2;

            board.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX()/ board.tSize;
        int line = e.getY()/ board.tSize;


        if(board.selPiece!=null){
            Move move = new Move(board, board.selPiece, col, line);
            if(board.canMove(move)){
                board.makeMove(move);
            }else {
                board.selPiece.xp = board.selPiece.col * board.tSize;
                board.selPiece.yp = board.selPiece.line * board.tSize;
            }
        }

        board.selPiece = null;
        board.repaint();
    }


}
