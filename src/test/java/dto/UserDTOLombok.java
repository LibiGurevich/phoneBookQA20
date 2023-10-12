package dto;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

public class UserDTOLombok {
@Getter
    @Setter
    @ToString
    @Builder

public class UserDTOLombok {

    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
}
