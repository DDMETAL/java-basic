package day04;

public class T extends Tetromino{
	
	T() {
		this(0, 0);
	}
	T(int row,int col) {
	super();//Ĭ���и�super���ø�����޲ι���
	cells[0]=new Cell(row,col);
	cells[1]=new Cell(row,col+1);
	cells[2]=new Cell(row,col+2);
	cells[3]=new Cell(row+1,col+1);
	}
	void print() {//��д����print����
		System.out.println("T");
		super.print();//���ø���print����
	}	
}
