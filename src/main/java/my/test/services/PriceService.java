package my.test.services;


import jakarta.persistence.EntityNotFoundException;
import my.test.entity.Price;
import my.test.repositories.PriceRepository;
import my.test.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PriceService {

    private final PriceRepository priceRepository;
    private final ProductRepository productsRepository;

    public PriceService(PriceRepository priceRepository, ProductRepository productsRepository) {
        this.priceRepository = priceRepository;
        this.productsRepository = productsRepository;
    }

    @Transactional(readOnly = true)
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Price getPriceById(Long priceId) {
        return priceRepository.findById(priceId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Price Id = {}", priceId)));
    }

    @Transactional
    public void deletePrice(Long priceId) {
        Price price = priceRepository.findById(priceId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Price Id = {}", priceId)));

        priceRepository.delete(price);
    }
}
