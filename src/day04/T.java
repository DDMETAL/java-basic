package day04;

public class T extends Tetromino{
	
	T() {
		this(0, 0);
	}
	T(int row,int col) {
	super();//默认有个super调用父类的无参构造
	cells[0]=new Cell(row,col);
	cells[1]=new Cell(row,col+1);
	cells[2]=new Cell(row,col+2);
	cells[3]=new Cell(row+1,col+1);
	}
	void print() {//重写父类print方法
		System.out.println("T");
		super.print();//调用父类print方法
	}	
}
