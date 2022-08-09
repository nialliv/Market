package ru.kit.backend.exception;

public class DeviceAlreadyExistException extends Exception {
    public DeviceAlreadyExistException(String message) {
        super(message);
    }
}
