public class People {
	private int age;
	private String name;

	public People() {
		super();
	}

	public People(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "People [age=" + age + ", name=" + name + "]";
	}

}
