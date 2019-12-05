package phc.com.br.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import phc.com.br.model.User;

@Service
public class TokenService {

	private final static Long EXPIRATION_TIME = 180000l;
	private String secretKey = "e9547221-4247-42f1-806f-4b32a1700035";
	
	public String generateToken(User user) {
		return Jwts.builder()
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(String.valueOf(user.getId()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
	
	public Claims decodeToken(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody();
	}
}
