package ru.kit.backend.exception;

public class DeviceNotFoundException extends Exception {
    public DeviceNotFoundException(String message) {
        super(message);
    }
}
