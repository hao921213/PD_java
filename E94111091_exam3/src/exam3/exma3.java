package exam3;
import java.util.Scanner;

public class exma3 {
    public static void main(String[] args) {
        int[][] board = new int[6][6];
        Scanner input = new Scanner(System.in);
        for (int i=0;i<6; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = input.nextInt();
            }
        }
        int time = input.nextInt();
        for (int i = 0; i < time; i++) {
            int[] a_lable=new int[2];
            int[] b_lable=new int[2];
            a_lable[0]=input.nextInt();
            a_lable[1]=input.nextInt();
            b_lable[0]=input.nextInt();
            b_lable[1]=input.nextInt();
            if (match(board, a_lable, b_lable)) {
                board[a_lable[0]][a_lable[1]]=0;
                board[b_lable[0]][b_lable[1]]=0;
                System.out.println("pair matched");
            } else {
                System.out.println("bad pair");
            }
        }
        input.close();
    }

    public static boolean match(int[][] board, int[] a_lable, int[] b_lable) {
        if (a_lable[0]==b_lable[0]) { 
        	if((a_lable[0]==0 && b_lable[0]==0) || (a_lable[1]==0 && b_lable[1]==0)) {
        		return true;
        	}
            for (int i = Math.min(a_lable[1], b_lable[1]) + 1; i < Math.max(a_lable[1], b_lable[1]); i++) {
                if (board[a_lable[0]][i] != 0) {
                    return false;
                }
            }
            return true;
        } 
        else if (a_lable[1] == b_lable[1]) { 
        	if((a_lable[0]==0 && b_lable[0]==0) || (a_lable[1]==0 && b_lable[1]==0)) {
        		return true;
        	}
            for (int i = Math.min(a_lable[0], b_lable[0]) + 1; i < Math.max(a_lable[0], b_lable[0]); i++) {
                if (board[i][a_lable[1]] != 0) {
                    return false;
                }
            }
            return true;
           
        }
        else {
        	
        }
        return false;  
    }
}
