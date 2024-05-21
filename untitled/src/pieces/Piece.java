package pieces;

import javax.imageio.ImageIO;

import main.Board;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.IOException;


public class Piece {
	public int col, line;		//linha e coluna da peça
	public int xp, yp;			//posicao da peça
	
	public boolean white;		//definir time da peça
	public String name;			//nome da peça
	public int val;				//valor da peça
	
	
	BufferedImage sheet;
	{
		try {
			sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("Pieces.png"));  //pega a imagem das peças
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected int sheetScale = sheet.getHeight()/2; //escala de cada peça dentro da imagem inteira
	
	
	Image sprite;		//sprite da peça
	
	Board board;		//tabuleiro
	
	public Piece(Board board) {
		this.board = board;
	}
	public void paint(Graphics2D g2d) {
		g2d.drawImage(sprite, xp, yp,null);
		
		
	}
}
