package phc.com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phc.com.br.model.User;
import phc.com.br.repository.UserRepository;

@Service
public class UserRegistrationService {

	@Autowired	
	private UserRepository userRepository;
	@Autowired
	private TokenService tokenService;

    public User registrate(User user){
        user.setToken(tokenService.generateToken(user));
        return userRepository.save(user);
    }
}
