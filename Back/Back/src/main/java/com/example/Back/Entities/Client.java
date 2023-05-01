package com.example.Back.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client extends Person{

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private List<Commandes> commandes;

    @OneToMany(cascade = CascadeType.ALL , mappedBy="client")
    private Set<Order> orders = new HashSet<>();
    public void add(Order order) {

        if (order != null){
            if(orders == null){
                orders = new HashSet<>();
            }

            orders.add(order);
            order.setClient(this);
        }
    }
}
