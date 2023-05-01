package com.example.Back.Controller;

import com.example.Back.DTO.Purchase;
import com.example.Back.DTO.PurchaseResponse;
import com.example.Back.ServicesImp.OrderServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clientOrder")
@AllArgsConstructor
public class OrderController {
    private final OrderServiceImp orderServiceImp;

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = orderServiceImp.placeOrder(purchase);
        return purchaseResponse;
    }
}
