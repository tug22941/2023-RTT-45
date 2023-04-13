package springexamples.formbeans;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class EmployeeFormBean {

    private Integer id;

    @NotEmpty (message = "First name is required")
    @Length(max=40, message="First name can not be longer than 40 characters")
    private String firstName;

    @NotEmpty (message = "Last name is required")
    private String lastName;

    private Integer officeId;
    private String extension;

    //@NotNull is valid if the value is not null or if the value is empty ("")
    //@NotEmpty is valid if the value is not null and the value is not empty(""), and the value length > 0

    @NotEmpty (message = "Email address is required")
    @Length(max=45, message="Email can not be longer than 45 characters")
    @Pattern(regexp="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message="Invalid Email Format")
    @EmailUnique
    private String email;

    private String jobTitle;

    @Max(value=100, message="You can not have more than 100 vacation hours")
    @Min(value=0, message="You can not have less than 0 vacation hours")
    private Integer vacationHours;

    private String profileImage;
}
