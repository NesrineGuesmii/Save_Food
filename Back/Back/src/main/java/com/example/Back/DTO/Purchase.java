package com.example.Back.DTO;

import com.example.Back.Entities.Client;
import com.example.Back.Entities.Order;
import com.example.Back.Entities.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Client customer;
    private Order order;
    private Set<OrderItem> orderItems;
}
