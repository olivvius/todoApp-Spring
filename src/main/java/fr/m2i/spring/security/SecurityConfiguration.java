package fr.m2i.spring.security;

import fr.m2i.spring.Service.ITodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private ITodoService todoService;
    private BCryptPasswordEncoder passwordEncoder;

    public SecurityConfiguration(ITodoService todoService, BCryptPasswordEncoder passwordEncoder) {
        this.todoService = todoService;
        this.passwordEncoder = passwordEncoder;
    }

    //methode pour configurer les url protegees ou pas
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login") //pour les requetes qui matchent cette uri
                .permitAll() //autoriser toutes les requetes , pas besoin detre conecte
                /*
                .anyRequest().authenticated() //pour les autres requete on demande authentification
                .and()
                .formLogin() //on active le formulaire de login
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                */
                 ;
        // on config notre page de login plutot que la page par defaut
        //.successForwardUrl("/");

        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

    //config la methode d'authentification
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication() //authent en memeoir
                .passwordEncoder(NoOpPasswordEncoder.getInstance()) //on ne veut pa que le mdp soit crypté
                .withUser("admin").password("admin") //on créé l'util admin
                .roles("USER", "ADMIN") //on lui assigne les roles user et admin
                .and()
                .withUser("manager").password("manager")
                .roles("USER","MANAGER");
        // .withUser("user").password("user")
        //  .and()
    }
     */
 /*
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(todoService);
        auth.setPasswordEncoder(passwordEncoder);
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
     */
}
