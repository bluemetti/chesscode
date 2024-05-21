package main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import pieces.*;

public class Board extends JPanel{

	public int tSize = 85;		//tamanho do quadrado de cada casa
	
	public int col = 8;		//numero de colunas
	public int line = 8;		//numero de linhas
	
	ArrayList<Piece> pList = new ArrayList<>();

	public Piece selPiece;

	Input input = new Input(this);

	public Board() {
		this.setPreferredSize(new Dimension(col * tSize, line * tSize));	//defini o tamanho do tabuleiro separadamente (numero de colunas*tamanho de cada casa e numero de linhas*tamanho de cada casa)
		this.addMouseListener(input);
		this.addMouseMotionListener(input);

		addP();


		this.setBackground(Color.green);				//assumi uma cor aleatória para o fundo do tabuleiro, apenas para ver sua posição no frame
	}


	public Piece getPiece(int col, int line){
		for (Piece p : pList){
			if (p.col == col && p.line == line) {
				return p;
			}
		}

		return null;
	}

	public void makeMove(Move move){
		move.piece.col = move.newCol;
		move.piece.line = move.newLine;

		move.piece.xp = move.newCol * this.tSize;
		move.piece.yp = move.newLine * this.tSize;

		capture(move);
	}

	public void capture(Move move){
		pList.remove(move.capture);
	}

	public boolean canMove(Move move){
		if (sameT(move.piece, move.capture)) return false;
		return true;
	}

	public boolean sameT(Piece p1, Piece p2){
		if(p1 == null || p2 == null) return false;
		return p1.white == p2.white;
	}

	public void addP() {
		pList.add(new King(this, 4, 7, true));
		pList.add(new King(this, 4, 0, false));

		pList.add(new Queen(this, 3, 7, true));
		pList.add(new Queen(this, 3, 0, false));

		pList.add(new Knight(this, 1, 7, true));
		pList.add(new Knight(this, 1, 0, false));
		pList.add(new Knight(this, 6, 7, true));
		pList.add(new Knight(this, 6, 0, false));

		pList.add(new Bishop(this, 2, 7, true));
		pList.add(new Bishop(this, 2, 0, false));
		pList.add(new Bishop(this, 5, 7, true));
		pList.add(new Bishop(this, 5, 0, false));

		pList.add(new Tower(this, 0, 7, true));
		pList.add(new Tower(this, 0, 0, false));
		pList.add(new Tower(this, 7, 7, true));
		pList.add(new Tower(this, 7, 0, false));

		for (int i = 0; i<8; i++){
			pList.add(new Pawn(this, i, 6, true));
			pList.add(new Pawn(this, i, 1, false));
		}

	}

	
	public void paintComponent(Graphics g) {	//sobrescreve o método paintComponent
		Graphics2D g2d = (Graphics2D) g;	//faz o casting de Graphics para Graphics 2D
		
		for(int l=0; l<line;l++)
			for(int c=0; c<line;c++) {
				g2d.setColor((c+l)%2==0? new Color(119, 71, 3) : new Color(234, 193, 123));		//dita a cor de cada parte do tabuleiro
				g2d.fillRect(c*tSize, l*tSize, tSize, tSize);				//"pinta" cada parte do tabuleiro
				
			}
		
		for (Piece piece : pList) {
			piece.paint(g2d);
		}
		
	}
}
