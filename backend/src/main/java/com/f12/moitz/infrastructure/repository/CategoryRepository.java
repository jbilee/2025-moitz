package com.f12.moitz.infrastructure.repository;

import com.f12.moitz.infrastructure.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
