package com.dawid.quilting.repository;

import com.dawid.quilting.entity.QuiltedIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuiltedIndexRepository extends JpaRepository<QuiltedIndex, Integer> {
}
