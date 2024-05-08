package Session23;
import java.util.*;

import Session22.EmployeePojoClass;

public class NestedJSONPojoClass {
	
	/*"Company Name":"XYZ LTD",
	"Street":"Africa Avenue",
	"City":"RK Puram Delhi",
	"State":"New Delhi",
	"Pin":"110066",
	"Bank Accounts":["HDFC","SBI","AXIS"],
	*/
	
	private String CompanyName;
	private String Street;
	private String City;
	private String State;
	private String Pin;
	private List<String> bankAccount;
	private List<EmployeePojoClass> employeeList;
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPin() {
		return Pin;
	}
	public void setPin(String pin) {
		Pin = pin;
	}
	public List<String> getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(List<String> bankAccount) {
		this.bankAccount = bankAccount;
	}
	public List<EmployeePojoClass> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeePojoClass> employeeList) {
		this.employeeList = employeeList;
	}
	

}
