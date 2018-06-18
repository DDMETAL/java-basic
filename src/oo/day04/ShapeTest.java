package oo.day04;
//��һ��ͼ������������
public class ShapeTest {

	public static void main(String[] args) {
		//shape s=new shape();//������󣬳����಻�ܴ�������
		shape[] shapes=new shape[4];
		shapes[0]=new Circle(1);
		shapes[1]=new Circle(2);
		shapes[2]=new Circle(1);
		shapes[3]=new Circle(2);
		maxArea(shapes);
	}
	//�������е�������
	public static void maxArea(shape[] shapes) {
		double max=shapes[0].area();
		int maxIndex=0;//�������±�
		for(int i=1;i<shapes.length;i++) {
			double area=shapes[i].area();
			if(area>max) {
				max=area;
				maxIndex=i;
			}
		}
		System.out.println(max+"�����±꣺"+maxIndex);
	}

}
abstract class shape{//������
	protected double c;//�ܳ�
	public abstract double area();//���󷽷�
}
class Circle extends shape{
	public Circle(double c) {
		this.c=c;
	}
	public double area() {//��д���󷽷�
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