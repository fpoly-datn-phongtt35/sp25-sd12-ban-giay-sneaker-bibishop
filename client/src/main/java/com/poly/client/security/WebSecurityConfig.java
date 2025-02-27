package com.poly.client.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtRequestFillter jwtRequestFillter;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/order", "/tai-khoan", "/tai-khoan/**", "/api/change-password", "/api/update-profile").authenticated()
                .antMatchers("/admin/**","/api/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/san-pham")
                .deleteCookies("JWT_TOKEN")
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFillter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/css/**", "/script/**", "/image/**", "/vendor/**", "/favicon.ico", "/adminlte/**", "/shop/**", "/media/static/**");
    }
}


//
//
//
//package com.poly.client.security;
//
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.context.annotation.Bean;
//        import org.springframework.context.annotation.Configuration;
//        import org.springframework.security.authentication.AuthenticationManager;
//        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//        import org.springframework.security.config.annotation.web.builders.WebSecurity;
//        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//        import org.springframework.security.config.http.SessionCreationPolicy;
//        import org.springframework.security.core.Authentication;
//        import org.springframework.security.core.AuthenticationException;
//        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//        import org.springframework.security.crypto.password.PasswordEncoder;
//        import org.springframework.security.web.AuthenticationEntryPoint;
//        import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//        import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//        import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//        import javax.servlet.ServletException;
//        import javax.servlet.http.HttpServletRequest;
//        import javax.servlet.http.HttpServletResponse;
//        import javax.servlet.http.HttpSession;
//        import java.io.IOException;
//
//@EnableWebSecurity
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @Autowired
//    private JwtRequestFillter jwtRequestFillter;
//
//    @Autowired
//    private JwtUserDetailsService jwtUserDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    protected void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception{
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity
//                .cors()
//                .and()
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/api/order", "/tai-khoan", "/tai-khoan/**", "/api/change-password", "/api/update-profile").authenticated()
//                .antMatchers("/admin/**","/api/admin/**").hasRole("ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .successHandler(new AuthenticationSuccessHandler() {
//
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                                        Authentication authentication) throws IOException, ServletException {
//
//                        response.sendRedirect("san-pham");
//
//                    }
//                })
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//                        HttpSession httpSession = request.getSession();
//
//                        if(exception.getMessage().equals("Bad credentials")) {
//                            httpSession.setAttribute("status", "bad-credentials");
//                            response.sendRedirect("/login?=BadCredentials");
//                            return;
//                        }
//
//                        if(exception.getMessage().equals("User is disabled")) {
//                            httpSession.setAttribute("status", "user-disabled");
//                            response.sendRedirect("/login?=AccountSuspended");
//                        }
//                    }
//                })
//                .loginPage("/login")
//                .and()
//                .logout()
//                .logoutUrl("/api/logout")
//                .logoutSuccessUrl("/san-pham")
//                .deleteCookies("JWT_TOKEN")
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilterBefore(jwtRequestFillter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/css/**", "/script/**", "/image/**", "/vendor/**", "/favicon.ico", "/adminlte/**", "/shop/**", "/media/static/**");
//    }
//}
