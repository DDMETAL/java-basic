package oo.day04;
//向上造型
public class UpDemo {
	public static void main(String[] args) {
		eoo e=new eoo();
		e.e=1;
		e.show();
		//e.f=1;//编译错误，父类不能访问子类
		foo f=new foo();
		f.f=2;
		f.print();
		f.e=3;//编译正确，子类能访问父类
		eoo o=new foo();//向上造型
		e.e=4;
		//e.f=5;//编译错误，能点出什么看引用类型

	}

}
class eoo{
	int e;
	void show() {}
}
class foo extends eoo{
	int f;
	void print() {}
}