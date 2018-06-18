package day07;

import java.util.Scanner;

public class TestPerson {
	public static void main(String[] args) {
		Person p=new Person() ;
		
		
	}
}
class Person{
	private String name;
	private String sex;
	private int age;
	Scanner scan=new Scanner(System.in);
	public Person() {
		super();
		this.name = scan.next();
		this.sex = scan.next();
		this.age = scan.nextInt();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}