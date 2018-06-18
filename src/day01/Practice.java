package day01;

import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		//九九乘法表
/*		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				int sum;
				sum=j*i;
				System.out.print(j+"*"+i+"="+sum+"\t");
			}
			System.out.println();
		}
*/
		//求数组元素最大值并放在最后一位
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
		System.out.println("最大值="+max);
		//把最大值放在第一个数
		int[] arr1= new int[arr.length+1];
		System.arraycopy(arr,0,arr1,1,arr.length);
		arr[0]=max;
		/把最大值放在最后一个数
		arr=Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=max;
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
*/		
		//冒泡排序
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
