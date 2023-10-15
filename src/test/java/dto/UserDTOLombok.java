package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Builder
@ToString
@Getter
public class UserDTOLombok {

    String email;
    String password;

}

