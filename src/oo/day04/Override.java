package oo.day04;
public class Override {//��д�����ص�����

	public static void main(String[] args) {
		
		roo r =new roo();
		yoo o=new xoo();
		r.test(o);

	}

}

class yoo{
	void show() {
		System.out.println("����");
	}
}
class xoo extends yoo{
	void show() {
		System.out.println("����");
	}
}
class roo{
	void test(yoo o) {
		System.out.println("���Ͳ���");
		o.show();
	}
	void test(xoo o) {
		System.out.println("���Ͳ���");
		o.show();
	}
}
