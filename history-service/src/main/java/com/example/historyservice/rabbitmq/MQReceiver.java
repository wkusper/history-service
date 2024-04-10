package com.example.historyservice.rabbitmq;

import com.example.historyservice.model.PrimesRecord;
import com.example.historyservice.repository.PrimeHistoryRepository;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MQReceiver {
    private final PrimeHistoryRepository primeHistoryRepository;

    public MQReceiver(PrimeHistoryRepository primeHistoryRepository) {
        this.primeHistoryRepository = primeHistoryRepository;
    }

    @RabbitListener(queues = {"primes"})
    public void receiveMessage(@Payload String message) {
        System.out.println(message);
        Gson gson = new Gson();
        PrimesRecord primesRecord = gson.fromJson(message, PrimesRecord.class);
        primeHistoryRepository.save(primesRecord);
    }

}
