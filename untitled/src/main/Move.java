package main;

import pieces.Piece;

public class Move {
    int oldCol;
    int oldLine;

    int newCol;
    int newLine;

    Piece piece;
    Piece capture;

    public Move(Board board, Piece piece, int newCol, int newLine){

        this.oldCol = piece.col;
        this.oldLine = piece.line;
        this.newCol = newCol;
        this.newLine = newLine;

        this.piece = piece;
        this.capture = board.getPiece(newCol, newLine);
    }
}
