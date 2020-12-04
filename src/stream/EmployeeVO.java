package stream;

public class EmployeeVO {
	private int EmpNo;
	private String LastName;
	private String email;
	private int salary;
	private int DepNo;

	public EmployeeVO(int empNo, String lastName, String email, int salary, int DepNo) {
		super();
		EmpNo = empNo;
		LastName = lastName;
		this.email = email;
		this.salary = salary;
		this.DepNo = DepNo;
	}

	public EmployeeVO() {

	}

	public int getEmpNo() {
		return EmpNo;
	}

	public void setEmpNo(int empNo) {
		EmpNo = empNo;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDepNo() {
		return DepNo;
	}

	public void setDepNo(int depNo) {
		DepNo = depNo;
	}

}
