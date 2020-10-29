package com.codegym.repository;

import com.codegym.entity.MyCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCountRepository extends JpaRepository<MyCount, Integer> {
}
