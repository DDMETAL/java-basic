package day03;

//引用数组
public class RefArrayDemo {
	public static void main(String[] args) {
		Cell[] cells =new Cell[2];
		cells[0]=new Cell(1,2);
		cells[1]=new Cell(3,4);

		Cell[] cs=new Cell[] {
				new Cell(1,2),
				new Cell(3,4)
		};
		
		int[][] arr=new int[2][];
		arr[0]=new int[2];
		arr[1]=new int[3];
		arr[0][0]=1;
	
		int[][] as=new int[2][3];
		for(int i=0;i<as.length;i++) {
			for(int j=0;j<as[i].length;j++) {
				as[i][j]=1;
			}
		}
	}
}
