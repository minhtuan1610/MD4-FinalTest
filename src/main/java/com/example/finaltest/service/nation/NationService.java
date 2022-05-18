package com.example.finaltest.service.nation;

import com.example.finaltest.model.Nation;
import com.example.finaltest.repository.INationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationService implements INationService {
    @Autowired
    INationRepository nationRepository;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Optional<Nation> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Nation save(Nation nation) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
