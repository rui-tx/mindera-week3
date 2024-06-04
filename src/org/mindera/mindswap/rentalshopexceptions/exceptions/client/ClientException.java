package org.mindera.mindswap.rentalshopexceptions.exceptions.client;

public abstract class ClientException extends Exception {

    public ClientException() {
        super("Car exception");
    }

    public ClientException(String message) {
        super(message);
    }
}
