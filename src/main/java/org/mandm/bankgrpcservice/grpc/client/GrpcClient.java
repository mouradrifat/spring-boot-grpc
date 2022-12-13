package org.mandm.bankgrpcservice.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.mandm.bankgrpcservice.grpc.stub.Bank;
import org.mandm.bankgrpcservice.grpc.stub.BankServiceGrpc;

import java.io.IOException;

public class GrpcClient {
    public static void main(String[] args) throws IOException {
        ManagedChannel managedChannel= ManagedChannelBuilder.forAddress("localhost",8888)
                .usePlaintext()
                .build();

        /*BankServiceGrpc.BankServiceBlockingStub blockingStub= BankServiceGrpc.newBlockingStub(managedChannel);
        Bank.ConvertCurrencyRequest.Builder builder = Bank.ConvertCurrencyRequest.newBuilder();
        builder.setCurrencyFrom("USD");
        builder.setCurrencyTo("MAD");
        builder.setAmount(98000);
        Bank.ConvertCurrencyRequest currencyRequest = builder.build();
        Bank.ConvertCurrencyResponse convertCurrencyResponse = blockingStub.convertCurrency(currencyRequest);
        System.out.println("*************************");
        System.out.printf("%f en %s => %f en %s%n",
                convertCurrencyResponse.getAmount(),convertCurrencyResponse.getCurrencyFrom(),
                convertCurrencyResponse.getConversionResult(),convertCurrencyResponse.getCurrencyTo());
        System.out.println("************************");*/

        BankServiceGrpc.BankServiceStub bankServiceStub=BankServiceGrpc.newStub(managedChannel);
        /*bankServiceStub.convertCurrency(currencyRequest, new StreamObserver<>() {
            @Override
            public void onNext(Bank.ConvertCurrencyResponse response) {
                System.out.println("===========================");
                System.out.printf("%f en %s => %f en %s%n",
                        response.getAmount(),response.getCurrencyFrom(),
                        response.getConversionResult(),response.getCurrencyTo());
                System.out.println("============================");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Exchange end");
            }
        });
        System.in.read();*/

        Bank.GetStreamOfTransactionsRequest getStreamOfTransactionsRequest = Bank.GetStreamOfTransactionsRequest.newBuilder()
                .setAccountId("CC1")
                .build();
        bankServiceStub.getStreamOfTransactionsRequest(getStreamOfTransactionsRequest, new StreamObserver<>() {
            @Override
            public void onNext(Bank.Transaction transaction) {
                System.out.println("**************** New transaction **************");
                System.out.println(transaction.getId());
                System.out.println(transaction.getAccountId());
                System.out.println(transaction.getAmount());
                System.out.println(transaction.getType());
                System.out.println(transaction.getStatus());
                System.out.println("***********************************************");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("************** completed ***************");
            }
        });

        System.in.read();
    }
}
