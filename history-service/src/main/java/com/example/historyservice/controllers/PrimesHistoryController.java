package com.example.historyservice.controllers;

import com.example.historyservice.model.PrimesRecord;
import com.example.historyservice.repository.PrimeHistoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesHistoryController {
    private final PrimeHistoryRepository primeHistoryRepository;
    public PrimesHistoryController(PrimeHistoryRepository primeHistoryRepository) {
        this.primeHistoryRepository = primeHistoryRepository;
    }
    @GetMapping("/{customer}")
    public List<PrimesRecord> findAll (@PathVariable String customer) {
        return primeHistoryRepository.findAllByCustomer(customer);
    }

}
