package springexamples.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserFormBean {

    private String email;
    private String password;
    private String fullName;
    private String confirmPassword;
}
