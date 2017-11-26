package tlocal;
import java.util.HashSet;
class Point{
	int x;
	int y;	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("==equals==");
		return false;
	}
}
public class HashSetDemo01 {
    public static void main(String[] args) {
	    HashSet<Point> set=new HashSet<Point>();
	    set.add(new Point(10,20));
	    set.add(new Point(10,20));
	    System.out.println(set.size());//2
    }
}
