package day04;

public class TJTest {

	public static void main(String[] args) {
		Tetromino t=new T(2,5);//��������(�Զ�����ת����
		t.print();
		printWall(t);//�����ͺ�ֵ
		J j=new J(1,4);
		j.print();
		printWall(j);//��ֵ��ͬʱ����
		
	}
	public static void printWall(Tetromino t) {
		for(int i=0;i<20;i++) {
			for(int j=0;j<10;j++) {
				//Ч�ʸߣ���չ�Ե�
				if(i==t.cells[0].row&&j==t.cells[0].col
				  ||i==t.cells[1].row&&j==t.cells[1].col
				  ||i==t.cells[2].row&&j==t.cells[2].col
			      ||i==t.cells[3].row&&j==t.cells[3].col) {
					System.out.print("* ");
				}else {
					System.out.print("- ");
				}
				//Ч�ʵͣ���չ�Ը�
				/*boolean flag=false;//�����-
				for(int k=0;k<t.cells.length;k++) {
					if(i==t.cells[k].row&&j==t.cells[k].col) {
						flag=true;//�޸�Ϊ��*
						break;
				}
			}
				if(flag) {//�жϵý��
					System.out.print("* ");
				}else {
					
						System.out.print("- ");
					}*/
	
		}
			
			System.out.println();
		}
	}
}
