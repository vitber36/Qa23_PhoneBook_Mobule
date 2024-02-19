package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Setter
@Getter
public class Auth {
    private String email;
    private String password;
}
