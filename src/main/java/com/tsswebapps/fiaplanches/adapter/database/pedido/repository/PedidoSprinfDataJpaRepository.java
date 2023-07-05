package com.tsswebapps.fiaplanches.adapter.database.pedido.repository;

import com.tsswebapps.fiaplanches.adapter.database.pedido.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoSprinfDataJpaRepository extends JpaRepository<PedidoEntity, Long> {
    Optional<PedidoEntity> findByComanda(String comanda);
}
