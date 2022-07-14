package edu.miu.eregistrarmvc;

import edu.miu.eregistrarmvc.model.Role;
import edu.miu.eregistrarmvc.model.User;
import edu.miu.eregistrarmvc.service.UserRoleService;
import edu.miu.eregistrarmvc.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ERegistrarMvcApplication implements CommandLineRunner {

    private final UserService userService;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public ERegistrarMvcApplication(UserService userService,
                                    UserRoleService userRoleService,
                                    PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(ERegistrarMvcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Role student = new Role("STUDENT", "This is a student role");
        student = userRoleService.saveUserRole(student);
        Role admin = new Role("ADMIN", "This is an admin role");
        admin = userRoleService.saveUserRole(admin);
        Role registrar = new Role("REGISTRAR", "This is a registrar role");
        registrar = userRoleService.saveUserRole(registrar);

        User anna = new User("611112",
                "Anna",
                "Benjamin",
                "Martin",
                "ana.admin@eregistrar.com",
                "ana",
                passwordEncoder.encode("ana"),
                LocalDate.of(2022, 1, 1),
                "Yes",
                "Male",
                List.of(admin));
        User bob = new User("611113",
                "Bob",
                "",
                "Rogan",
                "bob.registrar@eregistrar.com",
                "bob",
                passwordEncoder.encode("bob"),
                LocalDate.of(2021, 1, 1),
                "Yes",
                "Male",
                List.of(registrar));

        User carlos = new User("611113",
                "Carlos",
                "",
                "Rogan",
                "carlos.student@eregistrar.com",
                "carlos",
                passwordEncoder.encode("carlos"),
                LocalDate.of(2021, 1, 1),
                "Yes",
                "Male",
                List.of(student));

        List<User> users = userService.addNewStudents(List.of(anna, bob, carlos));

    }
}
