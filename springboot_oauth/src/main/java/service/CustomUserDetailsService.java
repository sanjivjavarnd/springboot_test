package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import entity.CustomUserDetails;
import entity.Users;
import repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> usersOptional = usersRepository.findByName(username);

		usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
		return usersOptional.map(CustomUserDetails::new).get();
	}
}