package com.performancelog.repository;

import com.performancelog.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    List<Performance> findByTitleContaining(String keyword);
    List<Performance> findByGenre(String genre);
}
