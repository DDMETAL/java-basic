package oo.day04;

public class NstInnerClassDemo {

	public static void main(String[] args) {
		int num=5;
		//������һ��inter4�����࣬����û�����֣�
		//Ϊ�����ഴ����һ������o1
		//��������Ϊ���������
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
