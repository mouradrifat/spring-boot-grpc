package org.mandm.bankgrpcservice.repository;

import org.mandm.bankgrpcservice.entities.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Long>  {
    List<AccountTransaction> findByAccountId(String accountId);
}
