package phc.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import phc.com.br.dto.UserAutheticatedDTO;
import phc.com.br.exception.InvalidLoginException;
import phc.com.br.model.Credencials;
import phc.com.br.model.User;
import phc.com.br.service.UserAuthenticationService;

@RestController
public class AuthenticationController {

	@Autowired
	private UserAuthenticationService userAuthenticationService;
    
    @PostMapping("/login")
    public ResponseEntity<Object> autenticar(@RequestBody Credencials dadosLogin, @RequestHeader String Authorization){
        User user = new User();
		try {
			user = userAuthenticationService.authenticate(dadosLogin, Authorization);
		} catch (InvalidLoginException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(new UserAutheticatedDTO(), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
		}
        return new ResponseEntity<Object>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }
}
