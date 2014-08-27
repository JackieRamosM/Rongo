package app.rongo;

/**
 *
 * @author SEHORE
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements Serializable, UserDetails {

private static final long serialVersionUID = 1L;
private Collection<SimpleGrantedAuthority> authorities;
private final String username;
private String password;

public User(String username) {
    this.username=username;
}

@Override
public Collection<SimpleGrantedAuthority> getAuthorities() {
    return authorities;

}
public void setUserAuthorities(List<String> roles) {
    List<SimpleGrantedAuthority> listOfAuthorities = new ArrayList<SimpleGrantedAuthority>();
    for (String role : roles) {
        listOfAuthorities.add(new SimpleGrantedAuthority(role));
    }
    authorities = listOfAuthorities;
}

@Override
public String getPassword() {
    return this.password;
}

@Override
public String getUsername() {
    return username;
}

@Override
public boolean isAccountNonExpired() {
    return true;//false
}

@Override
public boolean isAccountNonLocked() {
    return true;//false
}

@Override
public boolean isCredentialsNonExpired() {
    return true;//false
}

@Override
public boolean isEnabled() {
    return true;
}
}

