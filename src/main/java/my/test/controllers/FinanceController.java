package my.test.controllers;

import my.test.entity.Price;
import my.test.services.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class FinanceController {


    private final PriceService priceService;

    public FinanceController(PriceService priceService) {
        this.priceService = priceService;
    }
    @GetMapping("/")
    public List<Price> getAllPrices() {
        return priceService.getAllPrices();
    }

    @GetMapping("/{id}")
    public Price getPriceById(@PathVariable(value = "id") Long priceId) {
        return priceService.getPriceById(priceId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable(value = "id") Long priceId) {
        priceService.deletePrice(priceId);
        return ResponseEntity.noContent().build();
    }
}
