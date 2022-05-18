package com.example.finaltest.repository;

import com.example.finaltest.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationRepository extends PagingAndSortingRepository<Nation, Long> {
}
