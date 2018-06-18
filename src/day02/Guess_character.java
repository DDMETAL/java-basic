package day02;

import java.util.Scanner;

public class Guess_character {
	//主方法
	public static void main(String[] args) {
		char[] chs =Character();
		System.out.println(chs);
		int count=0;
		Scanner scan  =new Scanner(System.in);
		
		while(true) {
			System.out.println("猜:\n");
			String str=scan.next().toUpperCase();//获取用户输入的字符串并转换为大写	
			if(str.equals("EXIT")) {//String类型判断相等用equals方法
			System.out.println("退出");
			break;
		}
		char[] input=str.toCharArray();
		int[] result = check(chs,input);
		if(result[1]==chs.length) {
			int score=10*chs.length-1*count;
			System.out.println("猜对!\n"+"分数:"+score);
			break;
		}else {
			count++;
			System.out.println("字符对个数为"+result[0]+"位置对的个数"+result[1]);
		}
		}

	}
	//随机字符数组
	public static char[] Character() {
		char[] chs = new char[5];
		char[] letter = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean[] flags=new boolean[letter.length];//开关数组
		for(int i=0;i<chs.length;i++) {
			int index;
			do {
			 index = (int)(Math.random()*letter.length);
			}while(flags[index]==true);//当index下标对应的开关为true时表示已存过，则新生成index
			chs[i]=letter[index];//基于index下标到letter中获取字符，赋值给每个chs元素
			flags[index]=true;
		}
		
		return chs;
		
		
	}
	//对比结果
	public static int[] check(char[] chs,char[] input) {
		int[] result = new int[2];
		for(int i=0; i<chs.length;i++) {
			for(int j=0; j<input.length;j++) {
				if(chs[i]==input[j]) {//随机字符和输入字符对比
					result[0]++;//字符正确个数
					if(i==j) {
						result[1]++;//字符位置正确
					}
					break;
				}
			}
		}
		return result;
	}

}
