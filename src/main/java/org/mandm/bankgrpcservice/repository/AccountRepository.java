package org.mandm.bankgrpcservice.repository;

import org.mandm.bankgrpcservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
