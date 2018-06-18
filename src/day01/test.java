package day01;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入购买数量：");
		double number = scan.nextDouble();
		System.out.println("请输入商品单价：");
		double price = scan.nextDouble();
		System.out.println("请输入付款金额：");
		double money = scan.nextDouble();
		double totalPrice = number*price;//计算总价
		//总价小于等于300打8折
		if(totalPrice<=300) {
			totalPrice *= 0.8;
		}
		//总价大于等于500且小于等于700减100
		else if(500<=totalPrice&&totalPrice<=700) {
			totalPrice-=100;
		}
		//找零
		if(money<totalPrice) {
			System.out.println("应付金额不足");
		}
		else {
		double change =  money-totalPrice;
		System.out.println("商品总价="+totalPrice+"找零="+change);
		}
	}

}
