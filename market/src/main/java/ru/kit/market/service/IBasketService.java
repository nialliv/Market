package ru.kit.market.service;

import java.util.List;

import ru.kit.market.model.Basket;

public interface IBasketService {
    List<Basket> getAllBasket();
    long addProduct(Long productId);
    long deleteProductById(long id);
    long deleteBasketById(long id);
    boolean cleanBasket();
}
