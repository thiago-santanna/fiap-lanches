package com.tsswebapps.fiaplanches.adapter.database.item.repository;

import com.tsswebapps.fiaplanches.adapter.database.item.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaSpringDataJpaRepository extends JpaRepository<CategoriaEntity, Long> {
}
