package oo.day04;

public class StaticDemo {

	public static void main(String[] args) {
		Loo o1=new Loo();
		o1.show();
		Loo o2=new Loo();
		o2.show();

	}

}
class Loo{
	int a;//ʵ������
	static int b;//��̬����
	Loo(){
		a++;
		b++;
	}
	void show() {
		System.out.println(a);
		System.out.println(b);
	}
}