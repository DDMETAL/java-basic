package day01;

import java.util.Scanner;

public class cycle_structure {

	public static void main(String[] args) {
		//随机数加法
		int score=0;
		Scanner scan = new Scanner(System.in);
		for(int i=1;i<=10;i++) {
		 int number1 = (int)(Math.random()*100);
		 int number2 = (int)(Math.random()*100);
		 int sum=number1+number2;
		System.out.println("("+i+")"+number1+"+"+number2+"=");
		System.out.println("请计算");
		int result = scan.nextInt();
		if(result==-1) {
			break;
		}
		if(result==sum) {
			System.out.println("答对了");
			score+=10;
		}
		else {
			System.out.println("答错了");
		}
		}
		System.out.println("分数="+score);
		 
		 
		// 猜数字
		/*Scanner scan = new Scanner(System.in);
		int num=(int)(Math.random()*1000+1);//0-1000的随机数
		System.out.println(num);
		System.out.println("猜一个数：");
		int guess = scan.nextInt();
		do {
			if(guess==0) {
				break;
			}
			if(guess>num) {
				System.out.println("太大了");
			}else if(guess<num){
				System.out.println("太小了");
			}
		}while(guess!=num);
		if(guess==num) {
			System.out.println("猜对了");
		}else {
			System.out.println("下次继续");
		}*/
		/*while(guess!=num) {
			if(guess==0) {
				break;
			}
			if(guess>num) {
				System.out.println("太大了");
			}
				else {
					System.out.println("太小了");
				}
				System.out.println("请继续猜");
				guess = scan.nextInt();
			}
		if(guess==num) {
			System.out.println("猜对了");
		}
		else {
			System.out.println("下次继续");
		}*/
			
			
	}	
}
