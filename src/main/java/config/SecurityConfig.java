package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.cisco.security.AuthFailureHandler;
import com.cisco.security.AuthSuccessHandler;
import com.cisco.security.CiscoUserDetailsService;
import com.cisco.security.HttpAuthenticationEntryPoint;
import com.cisco.security.HttpLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CiscoUserDetailsService userDetailsService;
	@Autowired
	DataSource dataSource;
	@Autowired
	private AuthSuccessHandler authSuccessHandler;
	@Autowired
	private AuthFailureHandler authFailureHandler;
	@Autowired
	private HttpLogoutSuccessHandler logoutSuccessHandler;
	@Autowired
	private HttpAuthenticationEntryPoint authenticationEntryPoint;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(new ShaPasswordEncoder());

		return authenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(authenticationProvider());
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(
						"select email,password, 'true' from user where email=?")
				.authoritiesByUsernameQuery(
						"select email, 'ROLE_ADMIN' from user where email=?");
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * 
	 * auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles
	 * ("USER");
	 * auth.inMemoryAuthentication().withUser("admin").password("123456"
	 * ).roles("ADMIN"); auth.inMemoryAuthentication().withUser("dba").password
	 * ("123456").roles("DBA");
	 * 
	 * auth.jdbcAuthentication() .dataSource(dataSource) .usersByUsernameQuery(
	 * "select email,password, 'true' from user where email=?")
	 * .authoritiesByUsernameQuery(
	 * "select email, 'ROLE_ADMIN' from user where email=?"); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/index")
				.permitAll().antMatchers("/admin/**")
				.access("hasRole('ROLE_ADMIN')").antMatchers("/dba/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')").and()
				.exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint).and()
				.formLogin().usernameParameter("username")
				.passwordParameter("password")
				.successHandler(authSuccessHandler)
				.failureHandler(authFailureHandler).and().logout()
				.logoutSuccessHandler(logoutSuccessHandler);

		http.authorizeRequests().anyRequest().authenticated();
	}
}