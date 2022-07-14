package edu.miu.eregistrarmvc.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author bijayshrestha on 7/7/22
 * @project eRegistrar-mvc
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    @NotEmpty(message = "User number cannot be empty")
    @NotBlank(message = "User number cannot be null or blank")
    @Column(nullable = false)
    private String userUniqueID;

    @NotEmpty(message = "User Firstname cannot be empty")
    @NotBlank(message = "User Firstname cannot be null or blank")
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String middleName;

    @NotEmpty(message = "User Lastname cannot be empty")
    @NotBlank(message = "User Lastname cannot be null or blank")
    @Column(nullable = false)
    private String lastName;

    @NotEmpty(message = "Username cannot be empty")
    @NotBlank(message = "Username cannot be null or blank")
    @Column(nullable = false)
    private String username;

    @NotEmpty(message = "Email cannot be empty")
    @NotBlank(message = "Email cannot be null or blank")
    @Column(nullable = false)
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @NotBlank(message = "Password be null or blank")
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate enrollmentDate;

    @Column(nullable = false)
    private String isInternational;

    @NotNull
    @NotEmpty(message = "Gender cannot be empty")
    @NotBlank(message = "Gender cannot be null or blank")
    private String gender;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "userId", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = true
            ))
    private Collection<Role> roles = new ArrayList<>();
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public User(String userUniqueID,
                String firstName,
                String middleName,
                String lastName,
                String email,
                String username,
                String password,
                LocalDate enrollmentDate,
                String isInternational,
                String gender,
                Collection<Role> roles) {
        this.userUniqueID = userUniqueID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
        this.gender = gender;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] userRoles = getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
