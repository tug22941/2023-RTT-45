package springexamples.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_roles")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {

    //field attributes, with mapping
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // this is the FK in the user table
    @Column(name="user_id")
    private Integer userId;

    @Column(name="role_name")
    private String roleName;

}
