package com.example.Back.ServicesImp;

import com.example.Back.DTO.Purchase;
import com.example.Back.DTO.PurchaseResponse;
import com.example.Back.Entities.Client;
import com.example.Back.Entities.Order;
import com.example.Back.Entities.OrderItem;
import com.example.Back.Reposiroty.ClientRepository;
import com.example.Back.Services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService {

    private final ClientRepository clientRepository;

    private String generateOrderTrachingNumber(){
        return UUID.randomUUID().toString();
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();
        String orderTrackingNumber = generateOrderTrachingNumber();
        order.setOrder_tracking_number(orderTrackingNumber);
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        Client client = purchase.getCustomer();
        String theEmail = client.getEmail();
        Client userDB = clientRepository.findByEmail(theEmail);
        if(userDB!=null){
            client=userDB;
        }
        client.add(order);
        clientRepository.save(client);
        return new PurchaseResponse(orderTrackingNumber);
    }
}
