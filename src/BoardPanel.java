import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


public class BoardPanel extends JPanel{

	Board board;
	
	public BoardPanel(final Board board){
		this.board = board;
		board.boardPanel = this;
		board.fill();
		
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent clk){
				int x = clk.getX();
				int y = clk.getY();
				
				board.locationClicked(y /50,x /50);
				repaint();
			}
			
		});
		
	}
	
	public void paint(Graphics g){
		drawBoard(g);
		drawPieces(g);
		showPlaceable(g);
	}

	private void showPlaceable(Graphics g) {
		// TODO Auto-generated method stub
		int[][] temp = board.placeableLocation();
		
		for(int i = 0; i < 8; i++){
			for(int a = 0; a < 8; a++){
				g.setColor(Color.CYAN);
				if(temp[i][a] == 3 && board.grid[i][a] == 0){
					g.fillOval(a * 50 + 20, i * 50 + 20, 10, 10);
				}
			}
		}
	}

	private void drawPieces(Graphics g) {
		// TODO Auto-generated method stub
		int[][] temp = board.getGrid();
		
		for(int i = 0; i < 8; i++){
			for(int a = 0; a < 8; a++){
				g.setColor(board.color(a, i));
				g.fillOval(i * 50 + 2, a * 50 + 2, 46, 46);

			}
		}
	}

	private void drawBoard(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 400, 400);
		
		g.setColor(Color.BLACK);
		for(int i = 0; i < 8; i++){
			for(int a = 0; a < 8; a++){
				g.drawRect(i*50, a*50, 50, 50);
			}
		}
	}
}
