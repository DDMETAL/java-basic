package day01;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("�����빺��������");
		double number = scan.nextDouble();
		System.out.println("��������Ʒ���ۣ�");
		double price = scan.nextDouble();
		System.out.println("�����븶���");
		double money = scan.nextDouble();
		double totalPrice = number*price;//�����ܼ�
		//�ܼ�С�ڵ���300��8��
		if(totalPrice<=300) {
			totalPrice *= 0.8;
		}
		//�ܼ۴��ڵ���500��С�ڵ���700��100
		else if(500<=totalPrice&&totalPrice<=700) {
			totalPrice-=100;
		}
		//����
		if(money<totalPrice) {
			System.out.println("Ӧ������");
		}
		else {
		double change =  money-totalPrice;
		System.out.println("��Ʒ�ܼ�="+totalPrice+"����="+change);
		}
	}

}
