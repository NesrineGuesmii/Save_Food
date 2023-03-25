package com.example.Back.Entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "deliveryagent")
public class DeliveryAgent extends Person{

    @JsonManagedReference
    @OneToMany(mappedBy = "deliveryAgent")
    private List<Commandes> commandes;
}
