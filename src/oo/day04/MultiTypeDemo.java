package oo.day04;

public class MultiTypeDemo {

	public static void main(String[] args) {
			A o1=new B();//�������ͣ��Զ�����ת����
			B o2=(B)o1;//����o1ָ��Ķ��󣬾���B
			inter o3=(inter)o1;//����o1ָ��Ķ���ʵ����inter�ӿ�
			//C o4=(C)o1;
			if(o1 instanceof C) {
				C o5=(C)o1;
			}
			System.out.println("�쳣");

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