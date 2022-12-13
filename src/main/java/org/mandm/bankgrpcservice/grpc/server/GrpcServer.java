package org.mandm.bankgrpcservice.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.mandm.bankgrpcservice.grpc.service.BankGrpcServiceImpl;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server= ServerBuilder.forPort(9999)
                .addService(new BankGrpcServiceImpl())
                .build();
        server.start();
        server.awaitTermination();
    }
}
