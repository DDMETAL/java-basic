package day03;

public class Cell {
	int row;//�к�
	int col;//�к�
	Cell(){
		this(1,1);
	}
	Cell(int n){
		this(n,n);
	}
	Cell(int row,int col){
		this.row=row;
		this.col=col;
	}
	void drop() {//����1��
		row++;
	}
	void drop(int n) {
		row+=n;
	}
	void left(int n) {//����n��
		col-=n;
	}
	void left() {
		col--;
	}
	String getCellInfo() {//��ȡ�кź��к�
		return row+","+col;
	}

}
