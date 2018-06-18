package day03;

public class Cell {
	int row;//行号
	int col;//列号
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
	void drop() {//下落1格
		row++;
	}
	void drop(int n) {
		row+=n;
	}
	void left(int n) {//左移n格
		col-=n;
	}
	void left() {
		col--;
	}
	String getCellInfo() {//获取行号和列号
		return row+","+col;
	}

}
