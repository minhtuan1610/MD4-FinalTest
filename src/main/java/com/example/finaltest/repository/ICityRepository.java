package com.example.finaltest.repository;

import com.example.finaltest.model.City;
import com.example.finaltest.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends PagingAndSortingRepository<City, Long> {
    Iterable<City> findAllByNation(Nation nation);
}
