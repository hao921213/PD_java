import java.util.Scanner;
import java.util.ArrayList;
public class Hw5 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int row=input.nextInt();
		int column=input.nextInt();
		int num=0;
		boolean nofind=false;
		ArrayList<ArrayList<Point>> point = new ArrayList<>(row);
		ArrayList<ArrayList<Integer>> index = new ArrayList<>();
		for (int i = 0; i < row; i++) {
			point.add(new ArrayList<>());
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				String temp=input.next();
				Point value=new Point();
				value.Set(temp);
				point.get(i).add(value);
			}
		}
		
		String temp=input.next();
		String[] target=temp.split("");
		
		index.addAll(FindIndex(point,target));		
		for(int i=0;i<index.size();i++) {
			int x=index.get(i).get(0);
			int y=index.get(i).get(1);
			if(x==-1 && y==-1) {
				continue;
			}
			if(check(point,target,x,y,0)) {
				System.out.println("true");
				nofind=true;
				break;
			}
			for(int j=0;j<row;j++) {
				for(int k=0;k<column;k++) {
					point.get(j).get(k).Cancel();
				}
			}
		}
		if(!nofind) {
			System.out.println("false");
		}
		input.close();
	}
		public static ArrayList<ArrayList<Integer>> FindIndex(ArrayList<ArrayList<Point>> point, String target[]) {
	    ArrayList<ArrayList<Integer>> index = new ArrayList<>();
	    int row = point.size();
	    int column = point.get(0).size();

	    for (int i = 0; i < row; i++) {
	        for (int j = 0; j < column; j++) {
	            if (target[0].equals(point.get(i).get(j).Getchar())) {
	                ArrayList<Integer> coordinates = new ArrayList<>();
	                coordinates.add(i);
	                coordinates.add(j);
	                index.add(coordinates);
	            } else {
	                ArrayList<Integer> noMatch = new ArrayList<>();
	                noMatch.add(-1);
	                noMatch.add(-1);
	                index.add(noMatch);
	            }
	        }
	    }
	    return index;
	}
	public static boolean check(ArrayList<ArrayList<Point>> point, String target[], int x, int y, int num) {
	    int row = point.size();
	    int column = point.get(0).size();
	    if (x < 0 || x >= row || y < 0 || y >= column) {
	        return false;
	    }
	    	    if (!point.get(x).get(y).Getchar().equals(target[num]) || point.get(x).get(y).HaveUse()) {
	        return false;
	    }
	    	    if (num == target.length - 1) {
	        return true;
	    }
	    	    point.get(x).get(y).FirstTime();

	    if (check(point, target, x - 1, y, num + 1)) {
	        return true; 
	    }
	    if (check(point, target, x, y + 1, num + 1)) {
	        return true; 
	    }
	    if (check(point, target, x + 1, y, num + 1)) {
	        return true; 
	    }
	    if (check(point, target, x, y - 1, num + 1)) {
	        return true; 
	    }
	    	    return false;
	}
}

