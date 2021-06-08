package com.example.SpringAOP.repository;

import com.example.SpringAOP.entities.ExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionLogRepository extends JpaRepository<ExceptionLog,Long> {
}
