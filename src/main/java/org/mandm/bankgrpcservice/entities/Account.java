package org.mandm.bankgrpcservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mandm.bankgrpcservice.enums.AccountStatus;
import org.mandm.bankgrpcservice.enums.AccountType;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Account {
    @Id
    private String id;
    private double balance;
    private long createAt;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne
    private Currency currency;

    @OneToMany(mappedBy = "account")
    private List<AccountTransaction> accountTransactions;
}
