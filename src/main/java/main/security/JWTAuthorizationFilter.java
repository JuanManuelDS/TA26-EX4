package main.security;

import static main.security.Constants.HEADER_AUTHORIZACION_KEY;
import static main.security.Constants.SUPER_SECRET_KEY;
import static main.security.Constants.TOKEN_BEARER_PREFIX;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	public JWTAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//retorno el header del request, authorization key para ser exactos
		String header = req.getHeader(HEADER_AUTHORIZACION_KEY);
		
		//En caso que el cliente no tenga un token o este no comience con el token bearer(no es correcto), retorna null
		if (header == null || !header.startsWith(TOKEN_BEARER_PREFIX)) {
			chain.doFilter(req, res);
		
		} else {
			//En caso contrario, se retorna la autentificación de la request(req) 	
			UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(req, res);
		}
		
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		
		//Tomo el token con la clave "authorization" definida en la clase Constants
		String token = request.getHeader(HEADER_AUTHORIZACION_KEY);
		if (token != null) {
			// Se procesa el token y se recupera el usuario.
			String user = Jwts.parser()
						.setSigningKey(SUPER_SECRET_KEY)
						.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, "")) //Aquí le saco el token bearer prefix
						.getBody()
						.getSubject();

			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
			}
			return null;
		}
		return null;
	}
}