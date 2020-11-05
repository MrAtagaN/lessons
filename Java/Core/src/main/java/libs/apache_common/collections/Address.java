package libs.apache_common.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String locality;
    private String city;

}
