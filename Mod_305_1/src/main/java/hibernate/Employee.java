package hibernate;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "employees")
public class Employee {
	
	//field attributes, with mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="office_id")
	private Integer officeId;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="extension")
	private String extenstion;
	
	@Column(name="email")
	private String email;
	
	@Column(name="reports_to")
	private Integer reportsTo;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="vacation_hours")
	private Integer vacationHours;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Customer> customers;
	
	
	//default constructor
	public Employee() {
		
	}
	

	//accessors & mutators 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtenstion() {
		return extenstion;
	}

	public void setExtenstion(String extenstion) {
		this.extenstion = extenstion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(Integer reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getVacationHours() {
		return vacationHours;
	}

	public void setVacationHours(Integer vacationHours) {
		this.vacationHours = vacationHours;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	//toString method
	@Override
	public String toString() {
		return "Employee [id=" + id + ", officeId=" + officeId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extenstion=" + extenstion + ", email=" + email + ", reportsTo=" + reportsTo + ", jobTitle="
				+ jobTitle + ", vacationHours=" + vacationHours + "]";
	}
	
	
	
	
}
