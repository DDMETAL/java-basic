package day04;

public class Cell {
	int row,col;
	Cell(){
		this(0,0);
	}
	Cell(int n){
		this(n,n);
	}
	Cell(int row,int col){//构造方法
		this.row=row;
		this.col=col;
	}
	void drop(){
		row++;
	}
	void drop(int n) {//下落n格
		row+=n;
	}
	void moveLeft() {
		col--;
	}
	void moveLeft(int n) {//左移n格
		col-=n;
	}
	String getCellInfo() {//获取行列号
		return row+","+col;
	}
}
