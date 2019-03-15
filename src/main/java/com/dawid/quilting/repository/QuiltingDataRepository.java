package com.dawid.quilting.repository;

import com.dawid.quilting.entity.ProductionWorker;
import com.dawid.quilting.entity.QuiltingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface QuiltingDataRepository extends JpaRepository<QuiltingData, Integer> {
    QuiltingData getByDateAndOperator(LocalDate date, ProductionWorker operator);
}
