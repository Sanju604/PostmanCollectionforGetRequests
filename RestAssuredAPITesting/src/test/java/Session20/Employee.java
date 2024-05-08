package Session20;

public class Employee {
	
	/*  JSON Schema
{
	 "firstname":"Suresh",
	 "lastname":"Mehra",
     "gender":"Male",
     "age":35,
     "salary":10000.56
}     

*/
	
	private String firstname;
	private String lastname;
	private String gender;
	private int age;
	private double salary;
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getFirstName()
	{
		return firstname;
	}
	public void setFirstName(String firstname )
	{
		this.firstname=firstname;
	}
	

}
