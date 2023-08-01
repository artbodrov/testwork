package my.test.services;


import jakarta.persistence.EntityNotFoundException;
import my.test.entity.Actual;
import my.test.entity.Product;
import my.test.repositories.ActualRepository;
import my.test.repositories.PriceRepository;
import my.test.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnalysisService {

    private final PriceRepository priceRepository;
    private final ProductRepository productsRepository;
    private final ActualRepository actualRepository;

    public AnalysisService(PriceRepository priceRepository, ProductRepository productsRepository, ActualRepository actualRepository) {
        this.priceRepository = priceRepository;
        this.productsRepository = productsRepository;
        this.actualRepository = actualRepository;
    }


    @Transactional(readOnly = true)
    public List<Actual> getAllActuals() {
        return actualRepository.findAll();
    }


    @Transactional(readOnly = true)
    public List<Actual> getActual(
            List<String> chainNames,
            List<Integer> productsNumbers,
            Date date) {

        List<Product> products = productsRepository.findAllById(productsNumbers);

        products.stream().findAny().orElseThrow(() ->
                new EntityNotFoundException(String.format("Products Id = {}", productsNumbers
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")))));

        return actualRepository.findByName(chainNames, products, date);
    }
}
