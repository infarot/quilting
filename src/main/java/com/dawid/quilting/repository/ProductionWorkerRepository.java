package com.dawid.quilting.repository;

import com.dawid.quilting.entity.ProductionWorker;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductionWorkerRepository extends JpaRepository<ProductionWorker, Integer> {
}
