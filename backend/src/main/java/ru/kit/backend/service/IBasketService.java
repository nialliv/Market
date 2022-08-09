package ru.kit.backend.service;

import ru.kit.backend.model.Basket;
import ru.kit.backend.model.Device;

import java.util.List;

public interface IBasketService {
    List<Basket> getAllBasket();
    long addDevice(Device device);
    long deleteDeviceById(long id);
    long deleteBasketById(long id);
    boolean cleanBasket();
}
