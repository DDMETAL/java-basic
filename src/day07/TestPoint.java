package day07;

class Point2D {
	private double x;
	private double y;
	public Point2D() {
		this(0.0, 0.0);
	}
	public Point2D(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double distants(double a,double b) {
		return Math.sqrt((x-a)*(x-a)+(y-b)*(y-b));
	}
}
class Point3D extends Point2D{
	private double z;
	public Point3D() {
		this(0.0, 0.0,0.0);
	}
	public Point3D(double x, double y, double z) {
		super(x, y);
		this.z=z;
		
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public double distants(double a,double b,double c) {
		return Math.sqrt((getX()-a)*(getX()-a)+(getY()-b)*(getY()-b)+(z-c)*(z-c));
	}
}
public class TestPoint{
	public static void main(String[] args) {
		Point2D p1=new Point2D(3,4);
		Point3D p2=new Point3D(3,4,5);
		double d1=p1.distants(7, 8);
		double d2=p2.distants(6, 7, 8);
		System.out.println(d1+"  "+d2);
	}
}