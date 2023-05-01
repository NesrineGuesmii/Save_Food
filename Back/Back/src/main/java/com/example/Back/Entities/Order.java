package com.example.Back.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "orders  ")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Client client;

    private Date date;

    private String order_tracking_number;

    private double total_price;

    private int total_quantity;

    private boolean status;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "order")
    private Set<OrderItem> orderItems =new HashSet<>();

    public void add(OrderItem item) {
        if( item != null){
            if(orderItems == null){
                orderItems = new HashSet<>();
            }

            orderItems.add(item);
            item.setOrder(this);
        }
    }
}
