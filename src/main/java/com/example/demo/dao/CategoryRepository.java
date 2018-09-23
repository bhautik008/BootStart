package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
