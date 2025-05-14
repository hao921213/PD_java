import java.util.Scanner;

public class Hw3 {
	public static void main(String[] args) {
		int mainpoint_x,mainpoint_y,otherpoint_x,otherpoint_y,movevalue_x,movevalue_y=0;		
		int cmd=0;
		double csd=0;
		Scanner input=new Scanner(System.in);
		Point point=new Point();
		Point other=new Point();
		mainpoint_x=input.nextInt();
		mainpoint_y=input.nextInt();
		otherpoint_x=input.nextInt();
		otherpoint_y=input.nextInt();
		movevalue_x=input.nextInt();
		movevalue_y=input.nextInt();
		point.Set(mainpoint_x,mainpoint_y);
		other.Set(otherpoint_x,otherpoint_y);
		point.Move(movevalue_x,movevalue_y);
		for(int i=0;i<4;i++) {
			point.Rotate();
		}		
		cmd=point.calculateManhattanDistance(other);
		csd=point.ChebyshevDistance(other);
		input.close();
	}

}
