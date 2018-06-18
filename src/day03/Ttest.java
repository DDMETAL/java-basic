package day03;

public class Ttest {

	public static void main(String[] args) {
		T t=new T(2,5);
		t.print();
		System.out.println("ÏÂÂäºó£º");
		t.drop();
		t.print();
		System.out.println("×óÒÆºó£º");
		t.moveLeft();
		t.print();
	}

}
