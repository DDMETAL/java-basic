package oo.day04;

public class NstInnerClassDemo {

	public static void main(String[] args) {
		int num=5;
		//创建了一个inter4的子类，但是没有名字；
		//为该子类创建了一个对象o1
		//大括号中为该类的类体
		inter4 o1=new inter4(){
			public void show() {
				System.out.println("show");
				System.out.println(num);
				
			}
		};
		o1.show();
	}

}
interface inter4{
	void show();
}
