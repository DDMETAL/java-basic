package day04;

public class TJTest {

	public static void main(String[] args) {
		Tetromino t=new T(2,5);//向上造型(自动类型转换）
		t.print();
		printWall(t);//先造型后传值
		J j=new J(1,4);
		j.print();
		printWall(j);//传值的同时造型
		
	}
	public static void printWall(Tetromino t) {
		for(int i=0;i<20;i++) {
			for(int j=0;j<10;j++) {
				//效率高，扩展性低
				if(i==t.cells[0].row&&j==t.cells[0].col
				  ||i==t.cells[1].row&&j==t.cells[1].col
				  ||i==t.cells[2].row&&j==t.cells[2].col
			      ||i==t.cells[3].row&&j==t.cells[3].col) {
					System.out.print("* ");
				}else {
					System.out.print("- ");
				}
				//效率低，扩展性高
				/*boolean flag=false;//假设打-
				for(int k=0;k<t.cells.length;k++) {
					if(i==t.cells[k].row&&j==t.cells[k].col) {
						flag=true;//修改为打*
						break;
				}
			}
				if(flag) {//判断得结果
					System.out.print("* ");
				}else {
					
						System.out.print("- ");
					}*/
	
		}
			
			System.out.println();
		}
	}
}
