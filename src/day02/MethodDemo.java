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
	
	//无参有返回值
	public static int getNum() {
		//return;//必须跟一个数
	//	return 1.1;//必须与数据类型匹配
		return 1;
			
	}
	//有参有返回值
	public static double plus(double a,double b) {
		return a+b;
	}
	//无参无返回值
	public static void say() {
		System.out.println("d");
	}
	//有参无返回值
	public static void sayHi(String name) {
		System.out.println(name);
	}
}

	
