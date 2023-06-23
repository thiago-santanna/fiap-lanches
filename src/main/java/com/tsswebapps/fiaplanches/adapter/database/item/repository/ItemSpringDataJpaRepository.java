package com.tsswebapps.fiaplanches.adapter.database.item.repository;

import com.tsswebapps.fiaplanches.adapter.database.item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemSpringDataJpaRepository extends JpaRepository<ItemEntity, Long> {
}
