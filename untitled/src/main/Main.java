package main;
import javax.swing.*;



import java.awt.*;
public class Main {

	public static void main(String[] args) {
		//colocando o look and fell do Nimbus
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (InstantiationException ex) {
        	System.err.println(ex);
        } catch (IllegalAccessException ex) {
        	System.err.println(ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println(ex);
        }
		
		
		JFrame frame = new JFrame();						//instancia um JFrame
		frame.getContentPane().setBackground(Color.black);	//coloco o fundo fundo como preto
		frame.setLayout(new GridBagLayout());				//coloco o layout 
		frame.setMinimumSize(new Dimension(1000, 1000));	//coloco as dimensoes minimas da janela
		frame.setLocationRelativeTo(null);					//coloca a orientação do frame
		Board board = new Board();							//instancio o tabuleiro
		frame.add(board);									//insiro o tabuleiro no frame
		
		frame.setVisible(true);								//deixo o frame visivel
		
	}

}
