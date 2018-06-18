package oo.day04;
public class Override {//重写与重载的区别

	public static void main(String[] args) {
		
		roo r =new roo();
		yoo o=new xoo();
		r.test(o);

	}

}

class yoo{
	void show() {
		System.out.println("父类");
	}
}
class xoo extends yoo{
	void show() {
		System.out.println("子类");
	}
}
class roo{
	void test(yoo o) {
		System.out.println("父型参数");
		o.show();
	}
	void test(xoo o) {
		System.out.println("子型参数");
		o.show();
	}
}
