package oo.day04;
//��������
public class UpDemo {
	public static void main(String[] args) {
		eoo e=new eoo();
		e.e=1;
		e.show();
		//e.f=1;//������󣬸��಻�ܷ�������
		foo f=new foo();
		f.f=2;
		f.print();
		f.e=3;//������ȷ�������ܷ��ʸ���
		eoo o=new foo();//��������
		e.e=4;
		//e.f=5;//��������ܵ��ʲô����������

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