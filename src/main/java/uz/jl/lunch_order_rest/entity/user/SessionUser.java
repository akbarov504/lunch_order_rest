package uz.jl.lunch_order_rest.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Setter
@ToString
public class SessionUser implements UserDetails {
    private final Long id;
    private final UUID code;
    private final String username;
    private final String password;
    private final String position;

    public SessionUser(UserEntity user) {
        this.id = user.getId();
        this.code = user.getCode();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.position = user.getPosition();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();

        if (Objects.isNull(this.position)) {
            return authorities;
        }

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.position));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
