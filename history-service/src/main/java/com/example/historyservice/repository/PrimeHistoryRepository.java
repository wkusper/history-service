package com.example.historyservice.repository;

import com.example.historyservice.model.PrimesRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimeHistoryRepository extends CrudRepository<PrimesRecord, Integer>{
    List<PrimesRecord> findAllByCustomer(String customer);
}
