package com.example.cashcard;
import org.springframework.data.repository.CrudRepository;

public interface CashCardRepository extends CrudRepository<CashCard, Long> {
    // No need to explicitly implement methods - Spring Data provides them
}