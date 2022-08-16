package ru.kit.productapp.exception;

public class ProductAlreadyExistException extends Exception {
    public ProductAlreadyExistException(String message) {
        super(message);
    }
}
