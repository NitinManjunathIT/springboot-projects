package in.pwskills.nitin;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Test {

	public static void main(String[] args) {

		//Create a Secret Key
		String secrete = "SACHIN";
		
		//Creating a token
		String token = Jwts
						.builder()
						.setId("pw14404") //unique id
						.setSubject("nitin") //user data
						.setIssuedAt(new Date(System.currentTimeMillis()))//creation time
						.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(2)))//expiry time
						.setIssuer("PWSKILLS") //token provider name
						.signWith(SignatureAlgorithm.HS256, secrete.getBytes())//secured alogrithm,secrete
						.compact();
		
		System.out.println(token);
		
		//Retrieving the token data(Claims)
		Claims claims = Jwts
					.parser()
					.setSigningKey(secrete.getBytes())
					.parseClaimsJws(token)
					.getBody();
		
		System.out.println(claims.getSubject());
		System.out.println(claims.getIssuer());
		System.out.println(claims.getExpiration());	
	}

}
