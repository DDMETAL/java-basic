package day01;

import java.util.Scanner;

public class cycle_structure {

	public static void main(String[] args) {
		//������ӷ�
		int score=0;
		Scanner scan = new Scanner(System.in);
		for(int i=1;i<=10;i++) {
		 int number1 = (int)(Math.random()*100);
		 int number2 = (int)(Math.random()*100);
		 int sum=number1+number2;
		System.out.println("("+i+")"+number1+"+"+number2+"=");
		System.out.println("�����");
		int result = scan.nextInt();
		if(result==-1) {
			break;
		}
		if(result==sum) {
			System.out.println("�����");
			score+=10;
		}
		else {
			System.out.println("�����");
		}
		}
		System.out.println("����="+score);
		 
		 
		// ������
		/*Scanner scan = new Scanner(System.in);
		int num=(int)(Math.random()*1000+1);//0-1000�������
		System.out.println(num);
		System.out.println("��һ������");
		int guess = scan.nextInt();
		do {
			if(guess==0) {
				break;
			}
			if(guess>num) {
				System.out.println("̫����");
			}else if(guess<num){
				System.out.println("̫С��");
			}
		}while(guess!=num);
		if(guess==num) {
			System.out.println("�¶���");
		}else {
			System.out.println("�´μ���");
		}*/
		/*while(guess!=num) {
			if(guess==0) {
				break;
			}
			if(guess>num) {
				System.out.println("̫����");
			}
				else {
					System.out.println("̫С��");
				}
				System.out.println("�������");
				guess = scan.nextInt();
			}
		if(guess==num) {
			System.out.println("�¶���");
		}
		else {
			System.out.println("�´μ���");
		}*/
			
			
	}	
}
