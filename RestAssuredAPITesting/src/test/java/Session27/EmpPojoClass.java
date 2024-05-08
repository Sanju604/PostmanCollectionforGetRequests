package Session27;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpPojoClass {
	/*{
  "firstname" : "Suresh",
  "lastname" : "Mehra",
  "gender" : "Male",
  "age" : 45,
  "salary" : 35000.0,
  "hobbies" : ["Reading","Muscic"],
 "familymembers" : {

      "1":"Father",
      "2":"Mother"
    },
  "Married":true
}*/
	
	private String firstname;
	private String lastname;
	private String gender;
	private int age;
	private int salary;
	private String[] hobbies;
	private HashMap<String,String> familymembers;

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public HashMap<String, String> getFamilymembers() {
		return familymembers;
	}
	public void setFamilymembers(HashMap<String, String> familymembers) {
		this.familymembers = familymembers;
	}
	
}
