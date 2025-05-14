import java.util.Scanner;
public class Hw6 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] board=new String[9];
		int count_O=0;
		int count_X=0;
		int check=0;
		boolean invalid=false;
		board=input.next().split("");
		for(int i=0;i<9;i++) {
			if(board[i].equals("O")) {
				count_O++;
			}
			else if(board[i].equals("X")) {
				count_X++;
			}
		}
		if(count_O>count_X) {
			invalid=true;
		}
		check=Win(board);
		if(check==2) {
			invalid=true;
		}
		if(check==1) {
			if(count_O==count_X) {
				invalid=true;
			}
		}
		if(check==-1) {
			if(count_X>count_O) {
				invalid=true;
			}
		}
		if(invalid) {
			System.out.println("invalid");
		}
		else {
			System.out.println("valid");
		}
		
	}
	public static int Win(String[] board) {
		boolean win_O=false;
		boolean win_X=false;
				if(board[0].equals("O")) {//(1,2,3),(1,5,9),(1,4,7)
			if((board[1].equals("O")&&board[2].equals("O")) ||(board[3].equals("O")&&board[6].equals("O")) ||(board[4].equals("O")&&board[8].equals("O"))) {
				win_O=true;
			}
		}
		if(board[4].equals("O")) {//(4,5,6),(2,5,8),(3,5,7)
			if((board[3].equals("O")&&board[5].equals("O")) ||(board[1].equals("O")&&board[7].equals("O")) ||(board[2].equals("O")&&board[6].equals("O"))) {
				win_O=true;
			}
		}
		if(board[8].equals("O")) {//(7,8,9),(3,6,9)
			if((board[6].equals("O")&&board[7].equals("O")) ||(board[2].equals("O")&&board[5].equals("O"))) {
				win_O=true;
			}
		}
				if(board[0].equals("X")) {//(1,2,3),(1,5,9),(1,4,7)
			if((board[1].equals("X")&&board[2].equals("X")) ||(board[3].equals("X")&&board[6].equals("X")) ||(board[4].equals("X")&&board[8].equals("X"))) {
				win_X=true;
			}		
		}
		if(board[4].equals("O")) {//(4,5,6),(2,5,8),(3,5,7)
			if((board[3].equals("O")&&board[5].equals("O")) ||(board[1].equals("O")&&board[7].equals("O")) ||(board[2].equals("O")&&board[6].equals("O"))) {
				win_X=true;
			}
		}
		if(board[8].equals("O")) {//(7,8,9),(3,6,9)
			if((board[6].equals("O")&&board[7].equals("O")) ||(board[2].equals("O")&&board[5].equals("O"))) {
				win_X=true;
			}
		}
		if(win_O && win_X) {
			return 2;
		}
		else if(win_O) {
			return -1;
		}
		else if(win_X) {
			return 1;
		}
		return 0;
	}

}
