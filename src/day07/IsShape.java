package day07;

public class IsShape {
	public static void main(String[] args) {
		Circle c=new Circle(3);
		Rectangle r=new Rectangle(4,5);
		System.out.println(c.Area());
		System.out.println(r.Area());
	}

}
class Circle implements Shape{
	final static double PI=3.14;
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}


	public double Area() {
		
		return PI*radius*radius;
	}

}
class Rectangle extends Circle implements Shape{
	private double height;
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Rectangle(double radius, double height) {
		super(radius);
		this.height = height;
	}
	public  double Area() {
		return PI*getRadius()*getRadius()*height;
	}

	
}