package day02;

public class MethodDemo {

	
	public static void main(String[] args) {
		say();
		sayHi("d");
		
		double num = plus(1.1,2.2);
		System.out.println(num);
		int a=getNum();
		System.out.println(a);
	}
	
	//�޲��з���ֵ
	public static int getNum() {
		//return;//�����һ����
	//	return 1.1;//��������������ƥ��
		return 1;
			
	}
	//�в��з���ֵ
	public static double plus(double a,double b) {
		return a+b;
	}
	//�޲��޷���ֵ
	public static void say() {
		System.out.println("d");
	}
	//�в��޷���ֵ
	public static void sayHi(String name) {
		System.out.println(name);
	}
}

	
