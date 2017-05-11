package fr.laposte.simplon.security;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.laposte.simplon.models.Role;
import fr.laposte.simplon.repositories.UserRepository;

@Configuration
public class GlobalWebSecurityConfig extends GlobalAuthenticationConfigurerAdapter {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());		
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			
			@Override
			@Transactional
			public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				fr.laposte.simplon.models.User user = repository.findByEmail(email);				
				if (user != null) {
					//String[] listeRole = listerNomRole(utilisateur.getRoles());

					return new User(user.getEmail(),
									user.getPassword(),
									true, true, true, true, 
									AuthorityUtils.createAuthorityList("USER"));
				} else {
					throw new UsernameNotFoundException(email + " non trouvé.");
				}
			}
		};
	}
	
	private String[] listerNomRole(List<Role> listeRole) {
		String[] resultat = new String[listeRole.size()];
		
		for (Role role : listeRole) {
			resultat[listeRole.indexOf(role)] = role.getName();
		}
		return resultat;
	}	
}
