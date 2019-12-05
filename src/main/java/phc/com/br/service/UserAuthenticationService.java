package phc.com.br.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import phc.com.br.exception.ExpiredTokenException;
import phc.com.br.exception.InvalidLoginException;
import phc.com.br.exception.InvalidTokenException;
import phc.com.br.model.Credencials;
import phc.com.br.model.User;
import phc.com.br.repository.UserRepository;

@Service
public class UserAuthenticationService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenService tokenService;

	public User authenticate(Credencials dados, String token) throws InvalidLoginException {
		User user = userRepository.findByEmail(dados.getEmail());
		if (dados.getSenha().equals(user.getSenha()) && !token.isEmpty() && validate(token)) {
			String tokenReturn = tokenService.generateToken(user);
			user.setToken(tokenReturn);
			
			return user;
		} else {
			throw new InvalidLoginException();
		}
	}

	private boolean validate(String token) {
		try {
			String tokenTratado = token.replace("Bearer ", "");
			Claims claims = tokenService.decodeToken(tokenTratado);

            //Verifica se o token está expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
            
			return true;
		} catch (ExpiredJwtException et) {
			et.printStackTrace();
			throw new ExpiredTokenException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidTokenException();
		}
	}

}
