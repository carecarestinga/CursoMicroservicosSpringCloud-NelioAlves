package com.carecarestinga.msautentica.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carecarestinga.msautentica.entities.Usuario;
import com.carecarestinga.msautentica.feignclients.UsuarioFeignClient;

@Service
public class UsuarioService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UsuariorService.class);
	
	@Autowired
	private UsuarioFeignClient usuarioFeignClient;
	
	public Usuario findByEmail(String email) {
		Usuario usuario = usuarioFeignClient.findByEmail(email).getBody();
		if (usuario == null) {
			logger.error("Email não Encontrado: " + email);
			throw new IllegalArgumentException("Email não Encontrado");
		}
		logger.info("Email Encontrado: " + email);
		return usuario;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioFeignClient.findByEmail(username).getBody();
		if (usuario == null) {
			logger.error("Email não Encontrado: " + username);
			throw new UsernameNotFoundException("Email não Encontrado");
		}
		logger.info("Email Encontrado: " + username);
		return usuario;
	}
}
