package day07;

public class Bin_Oct_Hex_DecDemo {

	public static void main(String[] args) {
			int rgb=0x6c9d5d;
			int r=(rgb>>>16)&0xff;//��λ���
			int g=(rgb>>>8)&0xff;
			int b=rgb&0xff;
			int color=r|g|b;//��λ
			int _rgb=~rgb;//ȡ��
			int rgbl=rgb<<1;//����
			int rgbr=rgb>>1;//��ѧ����
			for(int i=0;i<5;i++) {//��λ��
				 int x=i&0x3;
				 int y=i%4;
				 System.out.println(x+","+y);
			}
			System.out.println(Integer.toBinaryString(rgb));
			System.out.println(Integer.toBinaryString(r));
			System.out.println(Integer.toBinaryString(g));
			System.out.println(Integer.toBinaryString(b));
			System.out.println(Integer.toBinaryString(color));
			System.out.println(Integer.toBinaryString(_rgb));
			System.out.println(Integer.toBinaryString(rgbl));
			System.out.println(Integer.toBinaryString(rgbr));

	}

}
