import java.awt.Color;
import javax.swing.*;
import javax.swing.JOptionPane;


public class Board {


	BoardPanel boardPanel;
	int[][] grid = new int[8][8];
	int turn = 0;

	public Board(){

	}	

	public void locationClicked(int x, int y) {
		// TODO Auto-generated method stub

		if(0 <= x && x < 8 && 0 <= y && y < 8){
			if(canPlace(x, y, turn) == true){
				if(grid[x][y] == 0){
					if(turn % 2 == 0){
						this.grid[x][y] = 1;
						boardPanel.repaint();
						//System.out.println("(" + x + "," + y + ")");

					}else{
						this.grid[x][y] = 2;
						boardPanel.repaint();
					}
					//System.out.println(canPlace(x, y, turn));
					replace(x, y, turn);
					turn++;
					
				}
//				else{
//					System.out.println(grid[x][y]);
//				}
			}
		}
		gameOver();
		
	}
	
	public int[][] placeableLocation(){
		int[][] temp = new int[8][8];
		
		for(int i = 0; i < 8; i++){
			for(int a = 0; a < 8; a++){
				if(canPlace(i, a, turn)){
					temp[i][a] = 3;
				}
			}
		}
		
		return temp;
	}

	public Color color(int i, int a){

		if(grid[i][a] == 1){
			return Color.BLACK;
		}
		if(grid[i][a] == 2){
			return Color.WHITE;
		}

		return Color.GREEN;
	}

	public int[][] getGrid(){
		return grid;
	}

	public boolean isValid(int x, int y){

		if(0 <= x && x < 8 && 0 <= y && y < 8){
			return true;
		}

		return false;
	}

	public void replace(int row, int col, int turn){
		int player = turn%2 + 1;

		int r = 1;
		int l = 1;
		int t = 1;
		int d = 1;
		int tr = 1;
		int tl = 1;
		int dr = 1;
		int dl = 1;

		if(player == 1){ //black
			while(isValid(row, col + r) == true && grid[row][col + r] == 2){ //right
				r++;
			}
			if(isValid(row, col + r) == true && grid[row][col + r] == 1 && r > 1){
				while(r > 0){
					grid[row][col + r] = 1;
					r--;
				}
			}
			r = 0;

			while(isValid(row, col - l) == true && grid[row][col - l] == 2){ //left
				l++;
			}
			if(isValid(row, col - l) == true && grid[row][col - l] == 1 && l > 1){
				while(l > 0){
					grid[row][col - l] = 1;
					l--;
				}
			}
			l = 0;

			while(isValid(row - t, col) == true && grid[row - t][col] == 2){ //up
				t++;
			}
			if(isValid(row - t, col) == true && grid[row - t][col] == 1 && t > 1){
				while(t > 0){
					grid[row - t][col] = 1;
					t--;
				}
			}
			t = 0;

			while(isValid(row + d, col) == true && grid[row + d][col] == 2){ //down
				d++;
			}
			if(isValid(row + d, col) == true && grid[row + d][col] == 1 && d > 1){
				while(d > 0){
					grid[row + d][col] = 1;
					d--;
				}
			}
			d = 0;

			while(isValid(row - tr, col + tr) == true && grid[row - tr][col + tr] == 2){ //top right
				tr++;
			}
			if(isValid(row - tr, col + tr) == true && grid[row - tr][col + tr] == 1 && tr > 1){
				while(tr > 0){
					grid[row - tr][col + tr] = 1;
					tr--;
				}
			}
			tr = 0;

			while(isValid(row - tl, col - tl) == true && grid[row - tl][col - tl] == 2){ //top left
				tl++;
			}
			if(isValid(row - tl, col - tl) == true && grid[row - tl][col - tl] == 1 && tl > 1){
				while(tl > 0){
					grid[row - tl][col - tl] = 1;
					tl--;
				}
			}
			tl = 0;

			while(isValid(row + dr, col + dr) == true && grid[row + dr][col + dr] == 2){ //down right
				dr++;
			}
			if(isValid(row + dr, col + dr) == true && grid[row + dr][col + dr] == 1 && dr > 1){
				while(dr > 0){
					grid[row + dr][col + dr] = 1;
					dr--;
				}
			}
			dr = 0;

			while(isValid(row + dl, col - dl) == true && grid[row + dl][col - dl] == 2){ //down left
				dl++;
			}
			if(isValid(row + dl, col - dl) == true && grid[row + dl][col - dl] == 1 && dl > 1){
				while(dl > 0){
					grid[row + dl][col - dl] = 1;
					dl--;
				}
			}
			dl = 0;
		}

		if(player == 2){ //white
			while(isValid(row, col + r) == true && grid[row][col + r] == 1){ //right
				r++;
			}
			if(isValid(row, col + r) == true && grid[row][col + r] == 2 && r > 1){
				while(r > 0){
					grid[row][col + r] = 2;
					r--;
				}
			}
			r = 0;

			while(isValid(row, col - l) == true && grid[row][col - l] == 1){ //left
				l++;
			}
			if(isValid(row, col - l) == true && grid[row][col - l] == 2 && l > 1){
				while(l > 0){
					grid[row][col - l] = 2;
					l--;
				}
			}
			l = 0;

			while(isValid(row - t, col) == true && grid[row - t][col] == 1){ //up
				t++;
			}
			if(isValid(row - t, col) == true && grid[row - t][col] == 2 && t > 1){
				while(t > 0){
					grid[row - t][col] = 2;
					t--;
				}
			}
			t = 0;

			while(isValid(row + d, col) == true && grid[row + d][col] == 1){ //down
				d++;
			}
			if(isValid(row + d, col) == true && grid[row + d][col] == 2 && d > 1){
				while(d > 0){
					grid[row + d][col] = 2;
					d--;
				}
			}
			d = 0;

			while(isValid(row - tr, col + tr) == true && grid[row - tr][col + tr] == 1){ //top right
				tr++;
			}
			if(isValid(row - tr, col + tr) == true && grid[row - tr][col + tr] == 2 && tr > 1){
				while(tr > 0){
					grid[row - tr][col + tr] = 2;
					tr--;
				}
			}
			tr = 0;

			while(isValid(row - tl, col - tl) == true && grid[row - tl][col - tl] == 1){ //top left
				tl++;
			}
			if(isValid(row - tl, col - tl) == true && grid[row - tl][col - tl] == 2 && tl > 1){
				while(tl > 0){
					grid[row - tl][col - tl] = 2;
					tl--;
				}
			}
			tl = 0;

			while(isValid(row + dr, col + dr) == true && grid[row + dr][col + dr] == 1){ //down right
				dr++;
			}
			if(isValid(row + dr, col + dr) == true && grid[row + dr][col + dr] == 2 && dr > 1){
				while(dr > 0){
					grid[row + dr][col + dr] = 2;
					dr--;
				}
			}
			dr = 0;

			while(isValid(row + dl, col - dl) == true && grid[row + dl][col - dl] == 1){ //down left
				dl++;
			}
			if(isValid(row + dl, col - dl) == true && grid[row + dl][col - dl] == 2 && dl > 1){
				while(dl > 0){
					grid[row + dl][col - dl] = 2;
					dl--;
				}
			}
			dl = 0;
		}

	}

	public boolean canPlace(int row, int col, int turn){
		int player = turn%2 + 1;

		int r = 1;
		int l = 1;
		int t = 1;
		int d = 1;
		int tr = 1;
		int tl = 1;
		int dr = 1;
		int dl = 1;

		if(player == 1){ //black
			while(isValid(row, col + r) == true && grid[row][col + r] == 2){ //right
				r++;
			}
			if(isValid(row, col + r) == true && grid[row][col + r] == 1 && r > 1){
				return true;
			}
			r = 0;

			while(isValid(row, col - l) == true && grid[row][col - l] == 2){ //left
				l++;
			}
			if(isValid(row, col - l) == true && grid[row][col - l] == 1 && l > 1){
				return true;
			}
			l = 0;

			while(isValid(row - t, col) == true && grid[row - t][col] == 2){ //up
				t++;
			}
			if(isValid(row - t, col) == true && grid[row - t][col] == 1 && t > 1){
				return true;
			}
			t = 0;

			while(isValid(row + d, col) == true && grid[row + d][col] == 2){ //down
				d++;
			}
			if(isValid(row + d, col) == true && grid[row + d][col] == 1 && d > 1){
				return true;
			}
			d = 0;


			while(isValid(row - tr, col + tr) == true && grid[row - tr][col + tr] == 2){ //top right
				tr++;
			}
			if(isValid(row - tr, col + tr) == true && grid[row - tr][col + tr] == 1 && tr > 1){
				return true;
			}
			tr = 0;

			while(isValid(row - tl, col - tl) == true && grid[row - tl][col - tl] == 2){ //top left
				tl++;
			}
			if(isValid(row - tl, col - tl) == true && grid[row - tl][col - tl] == 1 && tl > 1){
				return true;
			}
			tl = 0;

			while(isValid(row + dr, col + dr) == true && grid[row + dr][col + dr] == 2){ //down right
				dr++;
			}
			if(isValid(row + dr, col + dr) == true && grid[row + dr][col + dr] == 1 && dr > 1){
				return true;
			}
			dr = 0;

			while(isValid(row + dl, col - dl) == true && grid[row + dl][col - dl] == 2){ //down left
				dl++;
			}
			if(isValid(row + dl, col - dl) == true && grid[row + dl][col - dl] == 1 && dl > 1){
				return true;
			}
			dl = 0;
		}

		if(player == 2){ //white
			while(isValid(row, col + r) == true && grid[row][col + r] == 1){ //right
				r++;
			}
			if(isValid(row, col + r) == true && grid[row][col + r] == 2 && r > 1){
				return true;
			}
			r = 0;

			while(isValid(row, col - l) == true && grid[row][col - l] == 1){ //left
				l++;
			}
			if(isValid(row, col - l) == true && grid[row][col - l] == 2 && l > 1){
				return true;
			}
			l = 0;

			while(isValid(row - t, col) == true && grid[row - t][col] == 1){ //up
				t++;
			}
			if(isValid(row - t, col) == true && grid[row - t][col] == 2 && t > 1){
				return true;
			}
			t = 0;

			while(isValid(row + d, col) == true && grid[row + d][col] == 1){ //down
				d++;
			}
			if(isValid(row + d, col) == true && grid[row + d][col] == 2 && d > 1){
				return true;
			}
			d = 0;

			while(isValid(row - tr, col + tr) == true && grid[row - tr][col + tr] == 1){ //top right
				tr++;
			}
			if(isValid(row - tr, col + tr) == true && grid[row - tr][col + tr] == 2 && tr > 1){
				return true;
			}
			tr = 0;

			while(isValid(row - tl, col - tl) == true && grid[row - tl][col - tl] == 1){ //top left
				tl++;
			}
			if(isValid(row - tl, col - tl) == true && grid[row - tl][col - tl] == 2 && tl > 1){
				return true;
			}
			tl = 0;

			while(isValid(row + dr, col + dr) == true && grid[row + dr][col + dr] == 1){ //down right
				dr++;
			}
			if(isValid(row + dr, col + dr) == true && grid[row + dr][col + dr] == 2 && dr > 1){
				return true;
			}
			dr = 0;

			while(isValid(row + dl, col - dl) == true && grid[row + dl][col - dl] == 1){ //down left
				dl++;
			}
			if(isValid(row + dl, col - dl) == true && grid[row + dl][col - dl] == 2 && dl > 1){
				return true;
			}
			dl = 0;
		}

		return false;
	}

	public void gameOver(){
		int black = 0;
		int white = 0;
		if(checkGameOver() == true){
			for(int i = 0; i < 8; i++){
				for(int a = 0; a < 8; a++){
					if(grid[i][a] == 1){
						black++;
					}
					if(grid[i][a] == 2){
						white++;
					}
				}
			}
			JOptionPane j = new JOptionPane();
			if(black > white){
				j.showMessageDialog(null, "black has won with " +black+ " markers", "game over", 1);
				fill();
				turn  = 0;
			}
			if(black < white){
				j.showMessageDialog(null, "white has won with " +white+ " markers", "game over", 1);
				fill();
				turn = 0;
			}
		}
	
	}

	public boolean checkGameOver(){
		
		int[][] temp = placeableLocation();
		
		for(int i = 0; i < 8; i++){
			for(int a = 0; a < 8; a++){
				if(temp[i][a] == 3 && grid[i][a] == 0){
					return false;
				}
			}
		}
		

		return true;
	}

	public void fill(){
		for(int i = 0; i < 8; i++){
			for(int a = 0; a < 8; a++){
				grid[i][a] = 0;
			}
		}
		grid[3][3] = 2;
		grid[4][4] = 2;
		grid[4][3] = 1;
		grid[3][4] = 1;

	}

}
