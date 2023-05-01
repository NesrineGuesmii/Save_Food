package com.example.Back.Services;

import com.example.Back.DTO.Purchase;
import com.example.Back.DTO.PurchaseResponse;

public interface OrderService {
    PurchaseResponse placeOrder(Purchase purchase);
}
