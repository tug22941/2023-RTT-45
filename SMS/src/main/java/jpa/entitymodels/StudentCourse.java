package jpa.entitymodels;

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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//student course entity class

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_courses")
public class StudentCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer sCId;
	
	@Column(name = "student_id", insertable=false, updatable=false)
	private Integer sId;
	
	@Column(name = "course_id", insertable=false, updatable=false)
	private Integer cId;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
