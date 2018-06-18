package oo.day04;
//求一组图形中最大面面积
public class ShapeTest {

	public static void main(String[] args) {
		//shape s=new shape();//编译错误，抽象类不能创建对象
		shape[] shapes=new shape[4];
		shapes[0]=new Circle(1);
		shapes[1]=new Circle(2);
		shapes[2]=new Circle(1);
		shapes[3]=new Circle(2);
		maxArea(shapes);
	}
	//求数组中的最大面积
	public static void maxArea(shape[] shapes) {
		double max=shapes[0].area();
		int maxIndex=0;//最大面积下标
		for(int i=1;i<shapes.length;i++) {
			double area=shapes[i].area();
			if(area>max) {
				max=area;
				maxIndex=i;
			}
		}
		System.out.println(max+"数组下标："+maxIndex);
	}

}
abstract class shape{//抽象类
	protected double c;//周长
	public abstract double area();//抽象方法
}
class Circle extends shape{
	public Circle(double c) {
		this.c=c;
	}
	public double area() {//重写抽象方法
		return 0.0796*c*c;
	}
}
class Square extends shape{
	public Square(double c) {
		this.c=c;
	}
	public double area() {
		return 0.0625*c*c;
	}
}