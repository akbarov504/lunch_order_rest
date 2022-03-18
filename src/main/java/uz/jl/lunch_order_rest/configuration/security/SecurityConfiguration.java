package uz.jl.lunch_order_rest.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.jl.lunch_order_rest.configuration.security.filter.CustomAuthenticationFilter;
import uz.jl.lunch_order_rest.configuration.security.filter.CustomAuthorizationFilter;
import uz.jl.lunch_order_rest.service.token.TokenServiceImpl;
import uz.jl.lunch_order_rest.service.user.UserService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final TokenServiceImpl tokenService;
    private final UserService userService;
    private final PasswordEncoder encoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/auth/login/", "/api/auth/register/", "/api/user/accept-department/", "/api/department/**", "/api/meal/**", "/api/complaint/**", "/api/menu/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/auth/token/refresh/", "/api/department/**", "/api/meal/**", "/api/complaint/**", "/api/menu/**", "/api/user/get/**", "/api/user/get-by-phone/**", "/api/user/get-by-chatId/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.PATCH, "/api/department/**", "/api/meal/**", "/api/complaint/**", "/api/menu/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/department/**", "/api/meal/**", "/api/complaint/**", "/api/menu/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new CustomAuthenticationFilter(tokenService, authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
