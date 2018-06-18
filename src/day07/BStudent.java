package day07;
public class BStudent extends Student{
	private String profession;
	private String level;
	public BStudent(String name, int age, String profession, String level) {
		super(name, age);
		this.profession=profession;
		this.level=level;
	}
	
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void study() {
		System.out.println(getName()+getAge()+profession+level);
	}
}
