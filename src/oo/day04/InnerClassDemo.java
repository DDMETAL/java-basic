package oo.day04;

public class InnerClassDemo {

	public static void main(String[] args) {
		Outer o1=new Outer(1);
		o1.test();
		
		//Inner i=new Inner();//编译错误，内部类对外不具备可见性

	}

}
class Outer{//外部类
	private int num;
	Outer(int num){
		this.num=num;
		Inner i=new Inner();//内部类通常在外部类中创建对象
		i.show();
	}
	void test() {
		num++;
		System.out.println(num);
	}
	Inner createInner() {//内部类通常在外部类中创建对象
		return new Inner();
	}
	class Inner{//内部类
		void show() {
			System.out.println(num);
			System.out.println(Outer.this.num);
			//System.out.println(this.num);//编译错误，this指Inner
		}
	}
}