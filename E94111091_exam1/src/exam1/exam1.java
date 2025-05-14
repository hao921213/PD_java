package exam1;
import java.util.Scanner;

public class exam1 {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int time=Integer.parseInt(input.nextLine());
        for (int i=0;i<time;i++) {
            String s = input.nextLine();
            solve(s);
        }
        input.close();
    }

    public static void solve(String s) {
        String[] parts = s.split("=");
        int[] left = parseSide(parts[0]);
        int[] right = parseSide(parts[1]);

        int x=left[0]-right[0];
        int num=right[1]-left[1];

        if (x==0) {
            if (num==0) {
                System.out.println("Infinite solutions");
            }
            else {
            	System.out.println("No solution");
            }
        } else {
            int solution = num/x;
            System.out.println("x=" + solution);
        }
    }

    
    private static int[] parseSide(String side) {
        int x =0;
        int num=0;
        side = side.replace("-","+-");
        String[] terms = side.split("\\+");
        for (String term : terms) {
            if (term.contains("x")) {
                term = term.replace("x", "");
                if (term.equals("") || term.equals("+")) {
                	x+=1;
                }
                else if (term.equals("-")) {
                	x-=1;
                }
                else {
                	x+=Integer.parseInt(term);
                }
            } 
            else if (!term.isEmpty()) {
                num+=Integer.parseInt(term);
            }
        }
        int[] ans=new int[]{x,num};
        
        return ans;
    }
}
