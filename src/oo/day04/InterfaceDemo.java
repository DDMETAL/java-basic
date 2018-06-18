package oo.day04;

public class InterfaceDemo {
		//inter1 i=new inter1();//编译错误，不能被实例化
		inter1 o1;
		inter1 o2=new Aoo();
}

interface inter1{
	public static final int NUM=5;//常量
	int NUMBER=5;//默认在int前有 public static final
	public abstract void show();//抽象方法
	void display();//默认在void前有public abstract
}
interface inter2{
	void test();
	void display();
}
interface inter3 extends inter1{
	void write();
}
abstract class Boo{
	abstract void say();
}
class Aoo extends Boo implements inter1,inter2,inter3{
	public void show() {}
	public void display() {}
	public void test() {}
	void say() {}
	public void write() {}
	
	
}