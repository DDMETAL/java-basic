package day03;

public class CellTest {

	public static void main(String[] args) {
		Cell c1=new Cell();
		Cell c2=new Cell(2);
		Cell c3= new Cell(2,5);
		printWall(c3);
	
	}
	//打墙+打格子
	public static void printWall(Cell cc) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(i==cc.row&&j==cc.col) {
					System.out.print("* ");
				}
				else {
				System.out.print("- ");
				}
			}
			System.out.println();
		}
	}

}
