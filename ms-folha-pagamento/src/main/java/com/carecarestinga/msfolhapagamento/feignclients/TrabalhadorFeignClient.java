package com.carecarestinga.msfolhapagamento.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "trabalhador", path = "/trabalhadores")
public interface TrabalhadorFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhadorResponse> findById(@PathVariable("id") Long id);


}
