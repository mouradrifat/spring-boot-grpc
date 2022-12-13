package org.mandm.bankgrpcservice.repository;

import org.mandm.bankgrpcservice.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {
    Currency findByName(String name);
}
