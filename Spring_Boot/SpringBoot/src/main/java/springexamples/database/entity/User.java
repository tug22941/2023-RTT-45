package springexamples.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //field attributes, with mapping
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="full_name")
    private String fullName;
}
