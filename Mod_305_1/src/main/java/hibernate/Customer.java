package hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="Customers")
public class Customer {
	
	//Field Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")	
	private Integer id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="contact_lastname")
	private String contactLastname;
	
	@Column(name="contact_firstname")
	private String contactFirstname;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address_line1")
	private String addressLine1;
	
	@Column(name="address_line2")
	private String addressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="country")
	private String country;
	
	//insertable & updatable parameters essentially makes this a read only column
	// we added this because of the many-to-one mapping that is on the same column
	@Column(name="salesRepEmployeeNumber", insertable=false, updatable=false)
	private Integer salesRepEmployeeNumber;
	
	@Column(name="credit_limit", columnDefinition="decimal", precision=18, scale=3)
	private Double creditLimit;
	
	// this is the second column of 'salesRepEmployeeNumber'
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "salesRepEmployeeNumber", nullable = true)
    private Employee employee;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Payment> payments = new ArrayList<Payment>();
	
}
