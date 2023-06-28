package com.tsswebapps.fiaplanches.adapter.database.item.repository;

import com.tsswebapps.fiaplanches.adapter.database.item.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaSpringDataJpaRepository extends JpaRepository<CategoriaEntity, Long> {
    Optional<CategoriaEntity> findByDescricao(String descricao);
}
