package com.carecarestinga.msautentica.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carecarestinga.msautentica.entities.User;

@Component
@FeignClient(name = "ms-usuario", path = "/usuarios")
public interface UsuarioFeignClient {

	@GetMapping(value = "/email")
	ResponseEntity<Usuario> findByEmail(@RequestParam String email);
}
