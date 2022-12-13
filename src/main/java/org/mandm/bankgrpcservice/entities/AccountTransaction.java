package org.mandm.bankgrpcservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mandm.bankgrpcservice.enums.AccountStatus;
import org.mandm.bankgrpcservice.enums.AccountType;
import org.mandm.bankgrpcservice.enums.TransactionStatus;
import org.mandm.bankgrpcservice.enums.TransactionType;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountTransaction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long timestamp;
    private double amount;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    @ManyToOne
    private Account account;
}
