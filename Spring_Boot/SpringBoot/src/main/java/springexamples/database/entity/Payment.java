package springexamples.database.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Payments")
public class Payment {

    //field Attributes : with mapping
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="customer_id", insertable=false, updatable=false)
    private Integer customerId;

    @Column(name="check_number")
    private String checkNumber;

    @Column(name="payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name="amount", columnDefinition="decimal", precision=18, scale=3)
    private Double amount;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}

