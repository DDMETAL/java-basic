package day07;

public class YStudent extends Student {
	private String direction;

	public YStudent(String name, int age, String direction) {
		super(name, age);
		this.direction = direction;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void Study() {
		System.out.println(getName()+getAge()+direction);
	}
}
