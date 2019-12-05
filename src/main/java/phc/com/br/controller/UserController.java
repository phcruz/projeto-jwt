package phc.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import phc.com.br.dto.UserAutheticatedDTO;
import phc.com.br.dto.UserRegistrationDTO;
import phc.com.br.model.User;
import phc.com.br.service.UserRegistrationService;

@RestController
public class UserController {

	@Autowired
	private UserRegistrationService userRegistrationService;

    @PostMapping("/user")
    public ResponseEntity<UserAutheticatedDTO> registrate(@RequestBody UserRegistrationDTO userRegistrationDTO){
        User user = userRegistrationService.registrate(userRegistrationDTO.toUser());
        return  new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
    }
}
