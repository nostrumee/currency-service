package by.edu.currencyservice.persistence.repository;

import by.edu.currencyservice.persistence.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<Currency> findByCodeAndDate(String code, LocalDate date);

    boolean existsByDate(LocalDate date);
}
