package day03;

public class T {
	Cell[] cells;
	T(){
		this(0,0);
	}
	T(int row,int col){
		this.cells=new Cell[4];
		this.cells[0]=new Cell(row,col);
		this.cells[1]=new Cell(row,col+1);
		this.cells[2]=new Cell(row,col+2);
		this.cells[3]=new Cell(row+1,col+1);
	}
	void drop() {
		for(int i=0;i<this.cells.length;i++) {
			this.cells[i].row++;
		}
	}
	void moveLeft() {
		for(int i=0;i<this.cells.length;i++) {
			this.cells[i].col--;
		}
	}
	void moveRight() {
		for(int i=0;i<this.cells.length;i++) {
			this.cells[i].col++;
		}
	}
	void print() {
		for(int i=0;i<this.cells.length;i++) {
		 System.out.println(this.cells[i].getCellInfo());
		}
	}
}
