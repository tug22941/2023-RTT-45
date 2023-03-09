package hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="Products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")	
	private Integer id;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="productline_id")
	private Integer productLineId;
	
	@Column(name="product_scale")
	private String productScale;
	
	@Column(name="product_vendor")
	private String productVendor;
	
	@Column(name="product_description",  columnDefinition = "TEXT")
	private String productDescription;
	
	@Column(name="quantity_in_stock", columnDefinition="SMALLINT")
	private Integer qauntityInStock;
	
	@Column(name="buy_price", columnDefinition="decimal", precision=18, scale=3)
	private Double buy_price;
	
	@Column(name="msrp", columnDefinition="decimal", precision=18, scale=3)
	private double msrp;

	/*
	@ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "orderdetails",
            joinColumns = {
                    @JoinColumn(name = "customer_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
    */








}
