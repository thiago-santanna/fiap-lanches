package com.tsswebapps.fiaplanches.adapter.database.pedido.repository;

import com.tsswebapps.fiaplanches.adapter.database.pedido.entity.ItemPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoSpringDataJpaRepository extends JpaRepository<ItemPedidoEntity, Long> {

}
