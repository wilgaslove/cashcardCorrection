package bj.highfive.cashcard;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {
    private CashCardRepository cashCardRepository;

    public CashCardController(CashCardRepository c){
        this.cashCardRepository = c;
    }
    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard>  findById(@PathVariable Long requestedId) {
     Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);
     if (cashCardOptional.isPresent()) {
        //renvoyer l'objet avec le statut 200 ok
        return ResponseEntity.ok(cashCardOptional.get());
     } else {
        //renvoyer une erreur 404 not found
        return ResponseEntity.notFound().build();
     }
    }
}