import javax.swing.JFrame;


public class Driver {
	/*
	 * Pigyy!!! :D                         
 _._ _..._ .-',     _.._(`))
'-. `     '  /-._.-'    ',/
   )         \            '.
  / _    _    |             \
 |  a    a    /              |
 \   .-.                     ;  
  '-('' ).-'       ,'       ;
     '-;           |      .'
        \           \    /
        | 7  .__  _.-\   \
        | |  |  ``/  /`  /
       /,_|  |   /,_/   /
          /,_/      '`-'
	 */
	public static void main(String[] args){
		
		Board board = new Board();
		BoardPanel boardPanel = new BoardPanel(board);
		
		JFrame frame = new JFrame();
		frame.setTitle("Othello");
		frame.setSize(417,440);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.add(boardPanel);
	}
}
