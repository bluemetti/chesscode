package pieces;
import java.awt.image.BufferedImage;
import main.Board;

public class Bishop extends Piece{

    public Bishop(Board board, int col, int line, boolean white) {
        super(board);
        this.col = col;					//define a coluna da peça
        this.line = line;				//define a linha da peça
        this.xp = col * board.tSize;		//define a posição x da peça de acordo com a coluna em que está	e com relação ao tamanho das casas do tabuleiro
        this.yp = line * board.tSize;	//define a posição y da peça de acordo com a linha em que está e com relação ao tamanho das casas do tabuleiro
        this.white = white;				//define a cor da peça

        this.name = "Bishop";

        this.sprite = sheet.getSubimage(2*sheetScale, white? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tSize, board.tSize, BufferedImage.SCALE_SMOOTH);
        //usando o tamanho da escala, posição da peça cavalo e cor da peça, pega o devido sprite dentro da imagem inteira
    }

}