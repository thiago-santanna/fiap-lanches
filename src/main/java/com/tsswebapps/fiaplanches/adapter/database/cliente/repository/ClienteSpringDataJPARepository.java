package com.tsswebapps.fiaplanches.adapter.database.cliente.repository;

import com.tsswebapps.fiaplanches.adapter.database.cliente.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteSpringDataJPARepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByCpf(String cpf);
    Optional<ClienteEntity> findByEmail(String email);
}
