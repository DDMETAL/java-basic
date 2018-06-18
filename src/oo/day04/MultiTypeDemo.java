package oo.day04;

public class MultiTypeDemo {

	public static void main(String[] args) {
			A o1=new B();//向上造型（自动类型转换）
			B o2=(B)o1;//引用o1指向的对象，就是B
			inter o3=(inter)o1;//引用o1指向的对象实现了inter接口
			//C o4=(C)o1;
			if(o1 instanceof C) {
				C o5=(C)o1;
			}
			System.out.println("异常");

	}

}
interface inter{
	
}
class A{
	
}
class B extends A implements inter{
	
}
class C extends A{
	
}