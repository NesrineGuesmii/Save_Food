package com.example.Back.Entities;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "deliveryagent")
public class DeliveryAgent extends Person{

    @OneToMany(mappedBy = "deliveryAgent")
    private List<Commandes> commandes;
}
