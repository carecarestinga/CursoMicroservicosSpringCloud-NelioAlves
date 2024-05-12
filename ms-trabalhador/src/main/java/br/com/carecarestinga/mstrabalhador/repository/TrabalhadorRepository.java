package com.carecarestinga.mstrabalhador.repository;

import com.carecarestinga.mstrabalhador.model.Trabalhador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long> {

}
