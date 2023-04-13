package springexamples.formbeans;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import springexamples.validation.EmailUnique;

@Getter
@Setter
@ToString
public class CreateUserFormBean {

    private Integer id;

    @NotEmpty (message = "Email address is required")
    @Length(max=45, message="Email can not be longer than 45 characters")
    @Pattern(regexp="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message="Invalid Email Format")
    @EmailUnique
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;

    @NotEmpty(message = "Full Name is required")
    @Length(min=2, message="Full Name can not be shorter than 2 characters")
    private String fullName;

    @NotEmpty(message = "Confirm Password is required")
    private String confirmPassword;
}
