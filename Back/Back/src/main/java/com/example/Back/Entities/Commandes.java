package com.example.Back.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "commandes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commandes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private RestauAgent restauAgent;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "commandes")
    private List<Product> products;

    @ManyToOne
    private DeliveryAgent deliveryAgent;

    private String status;

}
