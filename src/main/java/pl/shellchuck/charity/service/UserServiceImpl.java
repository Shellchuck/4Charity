package pl.shellchuck.charity.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.shellchuck.charity.entity.Role;
import pl.shellchuck.charity.entity.User;
import pl.shellchuck.charity.repository.UserRepository;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleService roleService;
    private BCryptPasswordEncoder passwordEncoder;
    private EmailService emailService;


    public UserServiceImpl(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder passwordEncoder, EmailService emailService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleService.findRoleByName("ROLE_USER"));
        user.setRoles(roles);
        userRepository.save(user);

        String subject = "Potwierdzenie zarejestrowania konta w \"Oddam w dobre ręce\"";
        String text = String.format(
                "Dziękujemy za zrejestrowaniu konta w \"Oddam w dobre ręce\".");

        emailService.sendSimpleMessage(user.getEmail(), subject, text);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
