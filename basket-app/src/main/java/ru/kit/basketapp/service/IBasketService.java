package ru.kit.basketapp.service;

import java.util.List;

import ru.kit.basketapp.model.Basket;

public interface IBasketService {
    List<Basket> getAllBasket();
    long addProduct(Long productId);
    long deleteProductById(long id);
    long deleteBasketById(long id);
    boolean cleanBasket();
}
