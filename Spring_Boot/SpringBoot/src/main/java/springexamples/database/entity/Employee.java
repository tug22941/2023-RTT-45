package springexamples.database.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table (name = "employees")
@AllArgsConstructor
@NoArgsConstructor
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

    @ToString.Exclude
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Customer> customers = new ArrayList<Customer>();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customers == null) ? 0 : customers.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((extenstion == null) ? 0 : extenstion.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((officeId == null) ? 0 : officeId.hashCode());
        result = prime * result + ((reportsTo == null) ? 0 : reportsTo.hashCode());
        result = prime * result + ((vacationHours == null) ? 0 : vacationHours.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (customers == null) {
            if (other.customers != null)
                return false;
        } else if (!customers.equals(other.customers))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (extenstion == null) {
            if (other.extenstion != null)
                return false;
        } else if (!extenstion.equals(other.extenstion))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (jobTitle == null) {
            if (other.jobTitle != null)
                return false;
        } else if (!jobTitle.equals(other.jobTitle))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (officeId == null) {
            if (other.officeId != null)
                return false;
        } else if (!officeId.equals(other.officeId))
            return false;
        if (reportsTo == null) {
            if (other.reportsTo != null)
                return false;
        } else if (!reportsTo.equals(other.reportsTo))
            return false;
        if (vacationHours == null) {
            if (other.vacationHours != null)
                return false;
        } else if (!vacationHours.equals(other.vacationHours))
            return false;
        return true;
    }




}

