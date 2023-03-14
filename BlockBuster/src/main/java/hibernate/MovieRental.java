package hibernate;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "movie_rentals")
public class MovieRental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "movie_id", insertable=false, updatable=false)
	private Integer movieId;
	
	@Column(name = "user_id", insertable=false, updatable=false)
	private Integer userId;
	
	@Column(name = "checkout_date", columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.DATE)
	private Date checkoutDate;
	
	@Column(name = "checkin_date", columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.DATE)
	private Date checkinDate;
	
	@Column(name = "due_date")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
	



}
