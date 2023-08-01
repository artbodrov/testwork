package my.test.repositories;

import my.test.entity.Actual;
import my.test.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ActualRepository extends JpaRepository<Actual, Long> {
    List<Actual> findByName(
            List<String> chainNames,
            List<Product> products,
            Date date);
}