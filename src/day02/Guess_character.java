package day02;

import java.util.Scanner;

public class Guess_character {
	//������
	public static void main(String[] args) {
		char[] chs =Character();
		System.out.println(chs);
		int count=0;
		Scanner scan  =new Scanner(System.in);
		
		while(true) {
			System.out.println("��:\n");
			String str=scan.next().toUpperCase();//��ȡ�û�������ַ�����ת��Ϊ��д	
			if(str.equals("EXIT")) {//String�����ж������equals����
			System.out.println("�˳�");
			break;
		}
		char[] input=str.toCharArray();
		int[] result = check(chs,input);
		if(result[1]==chs.length) {
			int score=10*chs.length-1*count;
			System.out.println("�¶�!\n"+"����:"+score);
			break;
		}else {
			count++;
			System.out.println("�ַ��Ը���Ϊ"+result[0]+"λ�öԵĸ���"+result[1]);
		}
		}

	}
	//����ַ�����
	public static char[] Character() {
		char[] chs = new char[5];
		char[] letter = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean[] flags=new boolean[letter.length];//��������
		for(int i=0;i<chs.length;i++) {
			int index;
			do {
			 index = (int)(Math.random()*letter.length);
			}while(flags[index]==true);//��index�±��Ӧ�Ŀ���Ϊtrueʱ��ʾ�Ѵ������������index
			chs[i]=letter[index];//����index�±굽letter�л�ȡ�ַ�����ֵ��ÿ��chsԪ��
			flags[index]=true;
		}
		
		return chs;
		
		
	}
	//�ԱȽ��
	public static int[] check(char[] chs,char[] input) {
		int[] result = new int[2];
		for(int i=0; i<chs.length;i++) {
			for(int j=0; j<input.length;j++) {
				if(chs[i]==input[j]) {//����ַ��������ַ��Ա�
					result[0]++;//�ַ���ȷ����
					if(i==j) {
						result[1]++;//�ַ�λ����ȷ
					}
					break;
				}
			}
		}
		return result;
	}

}
