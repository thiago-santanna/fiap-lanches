package com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.repository;

import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataJPARepository extends JpaRepository<ClienteEntity, UUID> {
    Optional<ClienteEntity> findByCpf(String cpf);
}
