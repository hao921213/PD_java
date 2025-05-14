package exam2;

import java.util.ArrayList;
import java.util.Scanner;

public class exam2 {

	 public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        
	        ArrayList<ArrayList<Integer>> chessBoard = new ArrayList<>();
	        for (int i=0; i<10;i++) {
	            chessBoard.add(new ArrayList<>());
	            for (int j=0;j<10;j++) {
	                chessBoard.get(i).add(input.nextInt());
	            }
	        }

	        checkRow(chessBoard);
	        checkColumn(chessBoard);
	        checkLeftUp(chessBoard);
	        checkRightUp(chessBoard);
	        
	        for (int i=0; i<10; i++) {
	            for (int j=0; j<10; j++) {
	                if (chessBoard.get(i).get(j)==2) {
	                    System.out.print("X");
	                } else {
	                    System.out.print(chessBoard.get(i).get(j));
	                }
	                if (j != 9) {
	                    System.out.print(" ");
	                }
	            }
	            System.out.println("");
	        }
	    }

	    public static void checkRow(ArrayList<ArrayList<Integer>> chessBoard) {
	        for (int i=0; i<10; i++) {
	            for (int j=0; j<6; j++) {
	                int count=0;
	                for (int k=j; k<j+5;k++) {
	                    if (chessBoard.get(i).get(k)== 1) {
	                        count++;
	                    }
	                }
	                if (count== 4) {
	                    for (int k =j; k<j+5; k++) {
	                        if (chessBoard.get(i).get(k) == 0) {
	                            chessBoard.get(i).set(k,2);
	                        }
	                    }
	                }
	                
	            }
	        }
	        
	    }
	    public static void checkColumn(ArrayList<ArrayList<Integer>> chessBoard) {
	        for (int j=0;j<10;j++) {
	            for (int i=0;i<6;i++) {
	                int count=0;
	                for (int k= i;k<i+5;k++) {
	                    if (chessBoard.get(k).get(j)== 1) {
	                        count++;
	                    }
	                }
	                if (count== 4) {
	                    for (int k=i;k<i+5;k++) {
	                        if (chessBoard.get(k).get(j)== 0) {
	                            chessBoard.get(k).set(j,2);
	                        }
	                    }
	                }
	            }
	        }
	    }
	    public static void checkLeftUp(ArrayList<ArrayList<Integer>> chessBoard) {
	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < 6; j++) {
	                int count = 0;
	                int m = i;
	                for (int n = j; n < j + 5; n++) {
	                    if (chessBoard.get(m).get(n) == 1) {
	                        count++;
	                    }
	                    m++;
	                }
	                if (count == 4) {
	                    m = i;
	                    for (int n = j; n < j + 5; n++) {
	                        if (chessBoard.get(m).get(n) == 0) {
	                            chessBoard.get(m).set(n, 2);
	                        }
	                        m++;
	                    }
	              
	                
	                 }
	            }
	        }
	    }
	    public static void checkRightUp(ArrayList<ArrayList<Integer>> chessBoard) {
	        for (int i = 9; i > 3; i--) {
	            for (int j = 0; j < 6; j++) {
	                int count = 0;
	                int m = i;
	                for (int n = j; n < j + 5; n++) {
	                    if (chessBoard.get(m).get(n) == 1) {
	                        count++;
	                    }
	                    m--;
	                }
	                if (count == 4) {
	                    m = i;
	                    for (int n = j; n < j + 5; n++) {
	                        if (chessBoard.get(m).get(n) == 0) {
	                            chessBoard.get(m).set(n, 2);
	                        }
	                        m--;
	                    }
	                }
	            
	            
	            }
	        }
	    }
	    

}
