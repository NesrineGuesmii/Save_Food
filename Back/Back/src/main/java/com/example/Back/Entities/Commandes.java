package com.example.Back.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "commandes")
    private List<Product> products;

    @JsonBackReference
    @ManyToOne
    private DeliveryAgent deliveryAgent;

    private String status;

}
