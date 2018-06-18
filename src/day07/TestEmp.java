package day07;

public class TestEmp {
	 public static void main(String[] args) {
		Emp e1=new Emp("zhangsan",18,"nan");
		CEmp e2=new CEmp("lisi",19,"nv","post",3000);
		e1.display();
		e2.display();
	}
}
class Emp{
	private String name;
	private int age;
	private String sex;
	public Emp(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void display() {
		System.out.println(name+age+sex);
	}
}
class CEmp extends Emp{
	private String post;
	private double sal;
	public CEmp(String name, int age, String sex, String post, double sal) {
		super(name, age, sex);
		this.post = post;
		this.sal = sal;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public void display() {
		System.out.println(getName()+getAge()+getSex()+post+sal);
	}
}