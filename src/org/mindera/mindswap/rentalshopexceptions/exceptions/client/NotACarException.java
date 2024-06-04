package org.mindera.mindswap.rentalshopexceptions.exceptions.client;

public class NotACarException extends ClientException {
    public NotACarException() {
        super("Client can't drive this. This is not a car.");
    }

    public NotACarException(String message) {
        super(message);
    }
}
