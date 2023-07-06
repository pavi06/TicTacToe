import java.util.*;

public class Main {
	public static void main(String args[]) {
		
		//creating the board
		char[][] board=new char[3][3];
		
		//initializing the board
		for(int r=0;r<3;r++) {
			for(int c=0;c<3;c++) {
				board[r][c]=' ';
			}
		}
		//assigning the starting player to be x 
		char player='X';
		boolean gameOver=false;
		printboard(board);
		Scanner sc = new Scanner(System.in);
		while(!gameOver) {
			System.out.println("Enter player "+player+": ");
			int row=sc.nextInt();
			int col=sc.nextInt();
			if(board[row][col]==' ') {
				board[row][col]=player;
				gameOver=hasWon(board,player);
				if(gameOver) {
					System.out.println("Player "+player +" Won the game..!!");
				}else {
					gameOver=checkBoard(board);
				}
				player=player=='X'?'O':'X';
			}else {
				System.out.println("Invalid position..Try again!");
			}
			printboard(board);
		}
	}
	//checking for board--> draw or not
	private static boolean checkBoard(char[][] board) {
		for(int r=0;r<3;r++) {
			for(int c=0;c<3;c++) {
				if(board[r][c]==' ') {
					return false;
				}
			}
		}
		System.out.println("Both player doesn't win....Match DRAW!! ");
		return true;
	}
	
	//checking for player won or not
	private static boolean hasWon(char[][] board, char player) {
		//checking the column
		for(int c=0;c<3;c++) {
			if(board[0][c]==player && board[1][c]== player && board[2][c]==player) {
				return true;
			}
		}
		//checking the row
				for(int r=0;r<3;r++) {
					if(board[r][0]==player && board[r][1]== player && board[r][2]==player) {
						return true;
					}
				}
				//checking the diagonal
					if(board[0][0]==player && board[1][1]== player && board[2][2]==player) {
						return true;
					}
					if(board[0][2]==player && board[1][1]== player && board[2][0]==player) {
						return true;
					}
					
		
		return false;
	}
	//printing the board
	private static void printboard(char[][] board) {
		for(int r=0;r<3;r++) {
			for(int c=0;c<3;c++) {
				System.out.print(board[r][c]+" | ");
			}
			System.out.print("\n");
		}
		
	}
}
