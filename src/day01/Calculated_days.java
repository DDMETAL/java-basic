package day01;

public class Calculated_days {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int num=100;
		int count=0;
		for(int num=2;num<=100;num++) {
		boolean  flag=true;
		//for(int i=2;i<num;i++) {
		//for(int  i=2;i<=num/2;i++) {
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				flag=false;
				break;
			}	
		}
		if(flag) {
			count++;
		System.out.println(num+"ÊÇÖÊÊý");
		if(count%10==0) {
			System.out.println();
		}
		}
		
		}
		
		
	}

}
