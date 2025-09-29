package com.example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;


@RestController // Rest controller tells spring that this class is a contoller
@RequestMapping("/cashcards") // This maps this class to url "cashcards"
public class CashCardController {
    private final CashCardRepository cashCardRepository;

    private CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    // Method is the follow up to the one below
    // @PathVariable makes Spring aware of the "requestedId" in the http request to the server
    @GetMapping("/{requestedId}")
    private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);
        if (cashCardOptional.isPresent()) {
            return ResponseEntity.ok(cashCardOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/{requestedId}")
//    private ResponseEntity<CashCard> findById() {
//        CashCard cashCard = new CashCard(99L, 123.45);
//        return ResponseEntity.ok(cashCard);
//    }
}
