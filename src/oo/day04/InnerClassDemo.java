package oo.day04;

public class InnerClassDemo {

	public static void main(String[] args) {
		Outer o1=new Outer(1);
		o1.test();
		
		//Inner i=new Inner();//��������ڲ�����ⲻ�߱��ɼ���

	}

}
class Outer{//�ⲿ��
	private int num;
	Outer(int num){
		this.num=num;
		Inner i=new Inner();//�ڲ���ͨ�����ⲿ���д�������
		i.show();
	}
	void test() {
		num++;
		System.out.println(num);
	}
	Inner createInner() {//�ڲ���ͨ�����ⲿ���д�������
		return new Inner();
	}
	class Inner{//�ڲ���
		void show() {
			System.out.println(num);
			System.out.println(Outer.this.num);
			//System.out.println(this.num);//�������thisָInner
		}
	}
}