package org.mandm.bankgrpcservice.mappers;

import org.mandm.bankgrpcservice.entities.Account;
import org.mandm.bankgrpcservice.entities.AccountTransaction;
import org.mandm.bankgrpcservice.enums.AccountStatus;
import org.mandm.bankgrpcservice.enums.AccountType;
import org.mandm.bankgrpcservice.enums.TransactionStatus;
import org.mandm.bankgrpcservice.grpc.stub.Bank;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {
    public Bank.BankAccount fromBankCount(Account account){
        Bank.BankAccount bankAccount= Bank.BankAccount.newBuilder()
                .setAccountId(account.getId())
                .setBalance(account.getBalance())
                .setCreatedAt(account.getCreateAt())
                .setType(Bank.AccountType.valueOf(account.getType().toString()))
                .setState(Bank.AccountState.valueOf(account.getStatus().toString()))
                .build();
        return bankAccount;
    }
    public Account fromGrpcAccount(Bank.BankAccount bankAccount){
        Account account=new Account();
        account.setId(bankAccount.getAccountId());
        account.setBalance(bankAccount.getBalance());
        account.setCreateAt(bankAccount.getCreatedAt());
        account.setType(AccountType.valueOf(bankAccount.getType().toString()));
        account.setStatus(AccountStatus.valueOf(bankAccount.getState().toString()));
        return account;
    }

    public Bank.Transaction fromAccountTransaction(AccountTransaction accountTransaction){
        return Bank.Transaction.newBuilder()
                .setId(accountTransaction.getId())
                .setAccountId(accountTransaction.getAccount().getId())
                .setAmount(accountTransaction.getAmount())
                .setStatus(Bank.TransactionStatus.valueOf(accountTransaction.getStatus().toString()))
                .setType(Bank.TransactionType.valueOf(accountTransaction.getType().toString()))
                .build();
    }
}
