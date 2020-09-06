package libs.gson;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class User {

    @Expose
    private String firstName;
    @Expose(serialize = false)
    private String lastName;
    @Expose(serialize = false, deserialize = false)
    private String emailAddress;
    private String password;

}
