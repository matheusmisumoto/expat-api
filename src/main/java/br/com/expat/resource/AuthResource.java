package br.com.expat.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.expat.security.JWTUtil;
import br.com.expat.security.UserDetailsImpl;
import br.com.expat.service.UsuarioService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AuthResource {
	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping(value = "/refresh_token")
	@ApiOperation(value = "Autenticação")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserDetailsImpl user = UsuarioService.authenticated();
		if (user != null) {
			String token = jwtUtil.generateToken(user.getUsername());
			response.addHeader("Authorization", "Bearer " + token);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}

}
