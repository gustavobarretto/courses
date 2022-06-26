package com.dh.app1av1.repository;

import com.dh.app1av1.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatalogRepository extends JpaRepository<Catalog, Long> {
}
