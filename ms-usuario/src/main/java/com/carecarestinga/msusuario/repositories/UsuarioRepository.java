package com.carecarestinga.msusuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carecarestinga.msusuario.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);

}
