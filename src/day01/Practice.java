package day01;

import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		//�žų˷���
/*		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				int sum;
				sum=j*i;
				System.out.print(j+"*"+i+"="+sum+"\t");
			}
			System.out.println();
		}
*/
		//������Ԫ�����ֵ���������һλ
/*		int[] arr = new int[10] ;
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100);
			System.out.println(arr[i]);
		}
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];	
			}
		}
		System.out.println("���ֵ="+max);
		//�����ֵ���ڵ�һ����
		int[] arr1= new int[arr.length+1];
		System.arraycopy(arr,0,arr1,1,arr.length);
		arr[0]=max;
		/�����ֵ�������һ����
		arr=Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=max;
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
*/		
		//ð������
		int[] arr =new int[10];
		for(int k=0;k<arr.length;k++) {
			arr[k]=(int)(Math.random()*100);
			System.out.print(arr[k]+"\t");
		}
		System.out.println();
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
