package pl.mojaaplikacja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.mojaaplikacja.model.User;
import pl.mojaaplikacja.model.UserRole;
import pl.mojaaplikacja.repository.UserRepository;
import pl.mojaaplikacja.repository.UserRoleRepository;

@Service
public class UserService {

	private static final String DEFAULT_ROLE = "ROLE_USER";
	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setRoleRepository(UserRoleRepository userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}
	
	public void addWithDefaultRole(User user) {
		UserRole defaultRole = userRoleRepository.findByRole(DEFAULT_ROLE);
		user.getRoles().add(defaultRole);
		userRepository.save(user);
	}
}
