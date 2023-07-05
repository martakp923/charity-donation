package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@Transactional
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    @Email
    @NotBlank(message = "Proszę podać email")
    private String username;

   @Column(name = "password")
    @NotBlank(message = "Proszę podać hasło")
    @Size(min = 5, message = "Hasło musi mieć co najmniej 5 znaków")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
    }

    public User() {

    }

    @Column(name = "email_enabled", columnDefinition = "tinyint(1) default 0")
    private int isEnabled;
}


