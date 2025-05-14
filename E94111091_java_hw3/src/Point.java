public class Point {
	private int vertical=0;
	private int horizontal=0;
	void Set(int vertical, int horizontal) {
		this.vertical=vertical;
		this.horizontal=horizontal;
	}
	void Move(int x, int y) {
		System.out.println(vertical+" "+horizontal);
		vertical+=x;
		horizontal+=y;
		System.out.println(vertical+" "+horizontal);
	}
	void Rotate() {
		//轉90度x,y互換
		int cur=horizontal;
		horizontal=vertical;
		vertical=cur;
		horizontal*=-1;
		System.out.println(vertical+" "+horizontal);
	}
	int calculateManhattanDistance(Point other) {
		int cmd=0;
		int other_vertical=other.RetrieveVertical();
		int other_horizontal=other.RetrieveHorizontal();
		cmd=Math.abs(other_vertical-vertical)+Math.abs(other_horizontal-horizontal);
		System.out.println(cmd);
		return cmd;
	}
	double ChebyshevDistance(Point other) {
		double csd=0;
		double other_vertical=other.RetrieveVertical();
		double other_horizontal=other.RetrieveHorizontal();
		csd=Math.max(Math.abs(other_vertical-vertical),Math.abs(other_horizontal-horizontal));
		System.out.println(csd);
		return csd;
	}
	int RetrieveVertical() {
		return vertical;
	}
	int RetrieveHorizontal() {
		return horizontal;
	}
}
