package com.tsswebapps.fiaplanches.adapter.database.item.repository;

import com.tsswebapps.fiaplanches.adapter.database.item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemSpringDataJpaRepository extends JpaRepository<ItemEntity, Long> {
    Optional<ItemEntity> findByReferenciaFabricante(String ref);
}
