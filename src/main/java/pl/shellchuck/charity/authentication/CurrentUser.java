package pl.shellchuck.charity.authentication;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class CurrentUser extends User {

    private final pl.shellchuck.charity.entity.User user;

    public CurrentUser(String name, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.shellchuck.charity.entity.User user) {
        super(name, password, authorities);
        this.user = user;
    }

    public pl.shellchuck.charity.entity.User getUser() {
        return user;
    }
}
