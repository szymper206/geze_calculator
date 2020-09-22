package pl.coderslab.geze_calculator.user;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Entity
@Table(name = User.TABLE)
public class User {
    protected final static String TABLE = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
