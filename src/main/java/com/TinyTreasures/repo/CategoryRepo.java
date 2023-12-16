package com.TinyTreasures.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TinyTreasures.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
