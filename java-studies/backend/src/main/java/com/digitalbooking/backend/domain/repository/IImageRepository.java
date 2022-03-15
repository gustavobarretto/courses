package com.digitalbooking.backend.domain.repository;

import com.digitalbooking.backend.domain.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, String> {
}
